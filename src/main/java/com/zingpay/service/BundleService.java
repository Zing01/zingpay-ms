package com.zingpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.*;
import com.zingpay.entity.Bundle;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.TelenorIntegrationClient;
import com.zingpay.feign.ZongIntegrationClient;
import com.zingpay.repository.BundleRepository;
import com.zingpay.token.TokenGenerator;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import com.zingpay.util.TransactionStatus;
import com.zingpay.util.Utils;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@Service
@Transactional
public class BundleService {

    @Autowired
    private BundleRepository bundleRepository;

    @Autowired
    private ZongIntegrationClient zongIntegrationClient;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TelenorIntegrationClient telenorIntegrationClient;

    public List<Bundle> getBundles(String network) {
        return bundleRepository.findAllByNetwork(network);
    }

    public Status subscribeZongBundle(TransactionDto transactionDto) {
        ZongBundleDto zongBundleDto1 = new ZongBundleDto();
        ZongBundleDto zongBundleDto = zongBundleDto1.convertTransactionToDto(transactionDto);
        ZongBundleResponseDto zongBundleResponseDto = new ZongBundleResponseDto();
        System.out.println("zongBundleDto.getBundleId() " + zongBundleDto.getBundleId());
        Transaction savedTransaction = new Transaction();
        Status statusResponse = null;
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
            Transaction transaction = TransactionDto.convertToEntity(transactionDto);
            transaction.setDescription(zongBundleResponseDto.getDesc());

            if (zongBundleResponseDto.getDesc().contains("success")) {
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

    public Status subscribeTelenorBundle(TransactionDto transactionDto) {
        TelenorBundleDto telenorBundleDto1 = new TelenorBundleDto();
        TelenorBundleDto telenorBundleDto = telenorBundleDto1.convertTransactionToDto(transactionDto);
        TelenorBundleResponseDto telenorBundleResponseDto = new TelenorBundleResponseDto();
        Transaction savedTransaction = new Transaction();
        Status statusResponse = null;
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
        System.out.println("statusResponse.getMessage() " + statusResponse.getMessage());
        System.out.println("statusResponse.getReturnId() " + statusResponse.getReturnId());
        System.out.println("statusResponse.AdditionalDetail()" + statusResponse.getAdditionalDetail());
        if(statusResponse != null) {
            try {
                telenorBundleResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), TelenorBundleResponseDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("telenorBundleResponseDto.getMessage() " + telenorBundleResponseDto.getMessage());
            System.out.println("telenorBundleResponseDto.getRequestId() " + telenorBundleResponseDto.getRequestId());
            System.out.println("telenorBundleResponseDto.getTimestamp() " + telenorBundleResponseDto.getTimestamp());
            Transaction transaction = transactionService.getById(savedTransaction.getId());
            transaction.setRetailerRefNumber(transactionDto.getRetailerRefNumber() + "-" + telenorBundleResponseDto.getRequestId());
            System.out.println("just brefore if condition");
            if (telenorBundleResponseDto.getMessage().contains("Success")) {
                System.out.println("if condition start");
                transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                transaction.setDescription(telenorBundleResponseDto.getMessage());
                System.out.println("just before saving");
                savedTransaction = transactionService.save(transaction);
                System.out.println("just after saving");
                System.out.println("savedTransaction.getId() " + savedTransaction.getId());
                TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                System.out.println("transactionDtoToReturn.getId() " + transactionDtoToReturn.getId());
                return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
            } else {
                System.out.println("else condition");
                transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                transaction.setDescription(telenorBundleResponseDto.getErrorMessage());
                savedTransaction = transactionService.save(transaction);
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }
}
