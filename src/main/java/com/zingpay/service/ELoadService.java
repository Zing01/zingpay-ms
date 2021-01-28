package com.zingpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.*;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.TelenorIntegrationClient;
import com.zingpay.feign.ZongIntegrationClient;
import com.zingpay.token.TokenGenerator;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import com.zingpay.util.TransactionStatus;
import com.zingpay.util.Utils;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bilal Hassan on 08-Dec-20
 * @project zingpay-ms
 */

@Service
@Transactional
public class ELoadService {

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ZongIntegrationClient zongIntegrationClient;

    @Autowired
    private TelenorIntegrationClient telenorIntegrationClient;

    public Status performZongLoad(TransactionDto transactionDto) {
        ZongLoadDto zongLoadDto1 = new ZongLoadDto();
        ZongLoadDto zongLoadDto = zongLoadDto1.convertTransactionToDto(transactionDto);
        ZongLoadResponseDto zongLoadResponseDto = new ZongLoadResponseDto();
        Transaction savedTransaction = new Transaction();
        Status statusResponse = null;
        try {
            if (TokenGenerator.token == null) {
                try {
                    statusResponse = zongIntegrationClient.zongLoad(tokenGenerator.getTokenFromAuthService(), zongLoadDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                statusResponse = zongIntegrationClient.zongLoad(TokenGenerator.token, zongLoadDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                statusResponse = zongIntegrationClient.zongLoad(tokenGenerator.getTokenFromAuthService(), zongLoadDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
        if(statusResponse != null) {
            try {
                zongLoadResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), ZongLoadResponseDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("zongLoadResponseDto " + zongLoadResponseDto);

            Transaction transaction = TransactionDto.convertToEntity(transactionDto);
            transaction.setDescription(zongLoadResponseDto.getDesc());

            if (zongLoadResponseDto.getBossId() != null && !zongLoadResponseDto.getBossId().equals("")) {
                transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                savedTransaction = transactionService.save(transaction);
                TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
            } else {
                transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                savedTransaction = transactionService.save(transaction);
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }

    public Status performTelenorLoad(TransactionDto transactionDto) {
        TelenorLoadDto telenorLoadDto1 = new TelenorLoadDto();
        TelenorLoadDto telenorLoadDto = telenorLoadDto1.convertTransactionToDto(transactionDto);
        TelenorLoadResponseDto telenorLoadResponseDto = new TelenorLoadResponseDto();
        Transaction savedTransaction = new Transaction();
        Status statusResponse = null;
        try {
            if (TokenGenerator.token == null) {
                try {
                    statusResponse = telenorIntegrationClient.telenorLoad(tokenGenerator.getTokenFromAuthService(), telenorLoadDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                statusResponse = telenorIntegrationClient.telenorLoad(TokenGenerator.token, telenorLoadDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                statusResponse = telenorIntegrationClient.telenorLoad(tokenGenerator.getTokenFromAuthService(), telenorLoadDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }

        if (statusResponse != null) {
            try {
                telenorLoadResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), TelenorLoadResponseDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            Transaction transaction = TransactionDto.convertToEntity(transactionDto);
            transaction.setDescription(telenorLoadResponseDto.getResultMsg());
            
            if (telenorLoadResponseDto.getResultMsg() != null || !telenorLoadResponseDto.getResultMsg().equals("")) {
                transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                savedTransaction = transactionService.save(transaction);
                TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
            } else {
                transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                savedTransaction = transactionService.save(transaction);
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }
}
