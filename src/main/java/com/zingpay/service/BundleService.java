package com.zingpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.*;
import com.zingpay.entity.Bundle;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.CardWallaIntegrationClient;
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

    @Autowired
    private CardWallaIntegrationClient cardWallaIntegrationClient;

    public List<Bundle> getBundlesByNetwork(String network) {
        return bundleRepository.findAllByNetwork(network);
    }

    public List<Bundle> getBundlesByNetworkAndProductId(String network, String type) {
        return bundleRepository.findAllByNetworkAndType(network, type);
    }

    public Status subscribeZongBundle(TransactionDto transactionDto) {
        ZongBundleDto zongBundleDto1 = new ZongBundleDto();
        ZongBundleDto zongBundleDto = zongBundleDto1.convertTransactionToDto(transactionDto);
        ZongBundleResponseDto zongBundleResponseDto = new ZongBundleResponseDto();
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

        if(statusResponse != null) {
            try {
                zongBundleResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), ZongBundleResponseDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

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

        if(statusResponse != null) {
            try {
                telenorBundleResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), TelenorBundleResponseDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            Transaction transaction = TransactionDto.convertToEntity(transactionDto);
            transaction.setRetailerRefNumber(transactionDto.getRetailerRefNumber() + "-" + telenorBundleResponseDto.getRequestId());

            if (telenorBundleResponseDto.getMessage().contains("Success")) {
                transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                transaction.setDescription(telenorBundleResponseDto.getMessage());
                savedTransaction = transactionService.save(transaction);
                TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
            } else {
                transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                transaction.setDescription(telenorBundleResponseDto.getErrorMessage());
                savedTransaction = transactionService.save(transaction);
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }

    public Status subscribeCardwallaBundle(TransactionDto transactionDto) {
        CardWallaBundleDto cardWallaBundleDto1 = new CardWallaBundleDto();
        CardWallaBundleDto cardWallaBundleDto = cardWallaBundleDto1.convertTransactionToDto(transactionDto);
        CardWallaBundleResponseDto cardWallaBundleResponseDto = new CardWallaBundleResponseDto();
        Transaction savedTransaction = new Transaction();
        Status statusResponse = null;
        try {
            if (TokenGenerator.token == null) {
                try {
                    statusResponse = cardWallaIntegrationClient.subscribeBundle(tokenGenerator.getTokenFromAuthService(), cardWallaBundleDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                statusResponse = cardWallaIntegrationClient.subscribeBundle(TokenGenerator.token, cardWallaBundleDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                statusResponse = cardWallaIntegrationClient.subscribeBundle(tokenGenerator.getTokenFromAuthService(), cardWallaBundleDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }

        if(statusResponse != null) {
            try {
                cardWallaBundleResponseDto = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), CardWallaBundleResponseDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            Transaction transaction = TransactionDto.convertToEntity(transactionDto);
            transaction.setRetailerRefNumber(transactionDto.getRetailerRefNumber() + "-" + cardWallaBundleResponseDto.getAgentTransactionId());

            if (cardWallaBundleResponseDto.getResultCode().equals("0")) {
                transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                transaction.setDescription(cardWallaBundleResponseDto.getResultDescription());
                savedTransaction = transactionService.save(transaction);
                TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
            } else {
                transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                transaction.setDescription(cardWallaBundleResponseDto.getResultDescription());
                savedTransaction = transactionService.save(transaction);
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }
}
