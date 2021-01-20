package com.zingpay.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.*;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.BillPaymentIntegrationClient;
import com.zingpay.feign.CalculateCommissionClient;
import com.zingpay.feign.TelenorIntegrationClient;
import com.zingpay.feign.ZongIntegrationClient;
import com.zingpay.service.AppUserService;
import com.zingpay.service.TransactionService;
import com.zingpay.token.TokenGenerator;
import com.zingpay.util.Status;
import com.zingpay.util.TransactionStatus;
import com.zingpay.util.Utils;
import com.zingpay.util.ZingpayTransactionType;
import feign.FeignException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Bilal Hassan on 10/17/2020
 * @project zingpay-ms
 */

@Component
public class RabbitMQConsumer {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ZongIntegrationClient zongIntegrationClient;

    @Autowired
    private TelenorIntegrationClient telenorIntegrationClient;

    @Autowired
    private BillPaymentIntegrationClient billPaymentIntegrationClient;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private CalculateCommissionClient calculateCommissionClient;

    @Autowired
    private AppUserService appUserService;

    @Value("${queue.name}")
    private String queueName;

    @RabbitListener(queues = "${queue.name}")
    public void recievedMessage(Message message) {
        try {
            String jsonString = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("Message Received : ------- " + jsonString);
            TransactionDto transactionDto = transactionService.convertJSONStringToDto(jsonString);
            Transaction savedTransaction = null;//transactionService.processTransaction(transactionDto);
            transactionDto.setId(savedTransaction.getId());

            if(transactionDto.getServiceProvider().equalsIgnoreCase("ZONG")) {
                processZongTransaction(savedTransaction, transactionDto);
            } else if(transactionDto.getServiceProvider().equalsIgnoreCase("TELENOR")) {
                processTelenorTransaction(savedTransaction, transactionDto);
            } else if(transactionDto.getServiceProvider().equalsIgnoreCase("NADRA")) {
                performNadraBillPayment(savedTransaction, transactionDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processZongTransaction(Transaction savedTransaction, TransactionDto transactionDto) {
        Status statusResponse = null;
        if(transactionDto.getServiceId() == 50) {

        } else {
            ZongBundleDto zongBundleDto1 = new ZongBundleDto();
            ZongBundleDto zongBundleDto = zongBundleDto1.convertTransactionToDto(transactionDto);
            ZongBundleResponseDto zongBundleResponseDto = new ZongBundleResponseDto();
            System.out.println("zongBundleDto.getBundleId() " + zongBundleDto.getBundleId());
            try {
                if (TokenGenerator.token == null) {
                    try {
                        statusResponse = zongIntegrationClient.subscribeBundle(tokenGenerator.getTokenFromAuthService(), zongBundleDto);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    statusResponse = zongIntegrationClient.subscribeBundle(TokenGenerator.token, zongBundleDto);
                }
            } catch (FeignException.Unauthorized e) {
                try {
                    statusResponse = zongIntegrationClient.subscribeBundle(tokenGenerator.getTokenFromAuthService(), zongBundleDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("statusResponse.getAdditionalDetail() " + statusResponse.getAdditionalDetail());
            if(statusResponse != null) {
                try {
                    zongBundleResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), ZongBundleResponseDto.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                System.out.println("zongBundleResponseDto.getDesc() " + zongBundleResponseDto.getDesc());
                if (zongBundleResponseDto.getDesc().contains("success")) {
                    Transaction transaction = transactionService.getById(savedTransaction.getId());
                    transaction.setDescription(zongBundleResponseDto.getDesc());
                    transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                    transactionService.save(transaction);
                    //call commission microservice to calculate commission
                    calculateCommission(transaction);
                } else {
                    Transaction transaction = transactionService.getById(savedTransaction.getId());
                    transaction.setDescription(zongBundleResponseDto.getDesc());
                    transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                    transactionService.save(transaction);
                }
            }
        }
    }

    private void processTelenorTransaction(Transaction savedTransaction, TransactionDto transactionDto) {
        Status statusResponse = null;
        if(transactionDto.getServiceId() == 150) {

        } else {
            TelenorBundleDto telenorBundleDto1 = new TelenorBundleDto();
            TelenorBundleDto telenorBundleDto = telenorBundleDto1.convertTransactionToDto(transactionDto);
            TelenorBundleResponseDto telenorBundleResponseDto = new TelenorBundleResponseDto();
            try {
                if (TokenGenerator.token == null) {
                    try {
                        statusResponse = telenorIntegrationClient.subscribeBundle(tokenGenerator.getTokenFromAuthService(), telenorBundleDto);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    statusResponse = telenorIntegrationClient.subscribeBundle(TokenGenerator.token, telenorBundleDto);
                }
            } catch (FeignException.Unauthorized e) {
                try {
                    statusResponse = telenorIntegrationClient.subscribeBundle(tokenGenerator.getTokenFromAuthService(), telenorBundleDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            }
            if(statusResponse != null) {
                try {
                    telenorBundleResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), TelenorBundleResponseDto.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                Transaction transaction = transactionService.getById(savedTransaction.getId());
                transaction.setRetailerRefNumber(transactionDto.getRetailerRefNumber() + "-" + telenorBundleResponseDto.getRequestId());
                if (telenorBundleResponseDto.getMessage().contains("Success")) {
                    transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                    transaction.setDescription(telenorBundleResponseDto.getMessage());
                    transactionService.save(transaction);
                    //call commission microservice to calculate commission
                    calculateCommission(transaction);
                } else {
                    transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                    transaction.setDescription(telenorBundleResponseDto.getErrorMessage());
                    transactionService.save(transaction);
                }
            }
        }
    }

    private void performNadraBillPayment(Transaction savedTransaction, TransactionDto transactionDto) {
        BillPaymentDto billPaymentDto = BillPaymentDto.convertTransactionToDto(transactionDto);
        Status statusResponse = null;
        try {
            if (TokenGenerator.token == null) {
                try {
                    statusResponse = billPaymentIntegrationClient.billPayment(tokenGenerator.getTokenFromAuthService(), billPaymentDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                statusResponse = billPaymentIntegrationClient.billPayment(TokenGenerator.token, billPaymentDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                statusResponse = billPaymentIntegrationClient.billPayment(tokenGenerator.getTokenFromAuthService(), billPaymentDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("statusResponse.getAdditionalDetail() " + statusResponse.getAdditionalDetail());
        if(statusResponse.getAdditionalDetail() != null) {
            try {
                //BillPaymentResponseDto billPaymentResponseDto = Utils.parseToObject(statusResponse.getAdditionalDetail().toString(), BillPaymentResponseDto.class);
                BillPaymentResponseDto billPaymentResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), BillPaymentResponseDto.class);
                if(billPaymentResponseDto != null) {
                    if(billPaymentResponseDto.getStatus().equals("ok")) {
                        Transaction transaction = transactionService.getById(savedTransaction.getId());
                        transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                        transaction.setDescription(billPaymentResponseDto.getStatus());
                        transactionService.save(transaction);
                        //call commission microservice to calculate commission
                        calculateCommission(transaction);
                    } else {
                        Transaction transaction = transactionService.getById(savedTransaction.getId());
                        transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                        transactionService.save(transaction);
                    }
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    private void calculateCommission(Transaction transaction) {
        List<CalculateCommissionDto> calculateCommissionDtos = transactionService.getFee(transaction.getServiceId(), ZingpayTransactionType.TX_COMMISSION.getValue());
        List<Object> objs = appUserService.getAllAccountIdUsernameAccountTypeIdParentIdByAccountId(transaction.getAccountId());

        TransactionDto transactionDto1 = Transaction.convertToDto(transaction);

        TransactionCommissionDto transactionCommissionDto = new TransactionCommissionDto();
        transactionCommissionDto.setCalculateCommissionDtos(calculateCommissionDtos);
        transactionCommissionDto.setTransactionDto(transactionDto1);
        transactionCommissionDto.setAppUserDtoForCommissions(AppUserDtoForCommission.convertToDto(objs));

        List<TransactionDto> transactionDtos = null;
        try {
            if (TokenGenerator.token == null) {
                try {
                    transactionDtos = calculateCommissionClient.calculateCommission(tokenGenerator.getTokenFromAuthService(), transactionCommissionDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                transactionDtos = calculateCommissionClient.calculateCommission(TokenGenerator.token, transactionCommissionDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                transactionDtos = calculateCommissionClient.calculateCommission(tokenGenerator.getTokenFromAuthService(), transactionCommissionDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
        transactionService.saveAll(TransactionDto.convertToEntity(transactionDtos));
    }
}
