/*
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

*/
/**
 * @author Bilal Hassan on 10/17/2020
 * @project zingpay-ms
 *//*


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

    */
/*@Value("${queue.name}")
    private String queueName;*//*


    @RabbitListener(queues = "${queue.name.transaction}")
    public void recievedMessage(Message message) {
        try {
            String jsonString = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("Message Received : ------- " + jsonString);
            List<TransactionDto> transactionDtos = transactionService.convertJSONStringToDto(jsonString);
            transactionService.saveAll(TransactionDto.convertToEntity(transactionDtos));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
/*@RabbitListener(queues = "${queue.name}")
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
    }*//*


    private void processZongTransaction(Transaction savedTransaction, TransactionDto transactionDto) {
        Status statusResponse = null;
        if(transactionDto.getServiceId() == 50) {

        } else {

        }
    }

    private void processTelenorTransaction(Transaction savedTransaction, TransactionDto transactionDto) {
        Status statusResponse = null;
        if(transactionDto.getServiceId() == 150) {

        } else {

        }
    }

    private void performNadraBillPayment(Transaction savedTransaction, TransactionDto transactionDto) {

    }

    */
/*@Bean
    public Queue queue() {
        return new Queue(queueName);
    }*//*


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
*/
