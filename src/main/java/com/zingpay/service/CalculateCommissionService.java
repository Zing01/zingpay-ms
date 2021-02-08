package com.zingpay.service;

import com.zingpay.dto.*;
import com.zingpay.entity.Transaction;
import com.zingpay.rabbitmq.RabbitMQSender;
import com.zingpay.util.ZingpayTransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bilal Hassan on 20-Jan-21
 * @project zingpay-ms
 */

@Service
@Transactional
public class CalculateCommissionService {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private TransactionService transactionService;

    /*@Autowired
    private CalculateCommissionClient calculateCommissionClient;

    @Autowired
    private TokenGenerator tokenGenerator;*/

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Async
    public void calculateCommission(CommissionDto commissionDto) {
        rabbitMQSender.send(commissionDto);

        /*List<TransactionDto> transactionDtos = null;
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
        transactionService.saveAll(TransactionDto.convertToEntity(transactionDtos));*/
    }

    /*@Async
    public void calculateCommission(Transaction transaction) {
        List<CalculateCommissionDto> calculateCommissionDtos = transactionService.getFee(transaction.getServiceId(), ZingpayTransactionType.TX_COMMISSION.getValue());
        List<Object> objs = appUserService.getAllAccountIdUsernameAccountTypeIdParentIdByAccountId(transaction.getAccountId());

        TransactionDto transactionDto1 = Transaction.convertToDto(transaction);

        TransactionCommissionDto transactionCommissionDto = new TransactionCommissionDto();
        transactionCommissionDto.setCalculateCommissionDtos(calculateCommissionDtos);
        transactionCommissionDto.setTransactionDto(transactionDto1);
        transactionCommissionDto.setAppUserDtoForCommissions(AppUserDtoForCommission.convertToDto(objs));

        rabbitMQSender.send(transactionCommissionDto);

        *//*List<TransactionDto> transactionDtos = null;
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
        transactionService.saveAll(TransactionDto.convertToEntity(transactionDtos));*//*
    }*/
}
