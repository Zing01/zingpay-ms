package com.zingpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.zingpay.dto.BookMeBusDto;
import com.zingpay.dto.BookMeEventDto;
import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.BookMeIntegrationClient;
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
 * @author Bilal Hassan on 03-Mar-21
 * @project zingpay-ms
 */

@Service
@Transactional
public class BookMeService {

    @Autowired
    private BookMeIntegrationClient bookMeIntegrationClient;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private TransactionService transactionService;

    public Status bookEvent(TransactionDto transactionDto, BookMeEventDto bookMeEventDto) {
        Status statusResponse = null;
        Transaction savedTransaction = new Transaction();
        try {
            if (TokenGenerator.token == null) {
                try {
                    statusResponse = bookMeIntegrationClient.bookEvent(tokenGenerator.getTokenFromAuthService(), bookMeEventDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                statusResponse = bookMeIntegrationClient.bookEvent(TokenGenerator.token, bookMeEventDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                statusResponse = bookMeIntegrationClient.bookEvent(tokenGenerator.getTokenFromAuthService(), bookMeEventDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("statusResponse.getAdditionalDetail() " + statusResponse.getAdditionalDetail());
        if(statusResponse.getAdditionalDetail() != null) {
            try {
                JsonNode jsonNode = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), JsonNode.class);
                Transaction transaction = TransactionDto.convertToEntity(transactionDto);
                if(jsonNode != null && !jsonNode.equals("")) {
                    if(jsonNode.get("response").asText().equalsIgnoreCase("Success")) {
                        transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                        transaction.setDescription(jsonNode.get("response").asText());
                        savedTransaction = transactionService.save(transaction);
                        TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                        return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
                    } else {
                        transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                        savedTransaction = transactionService.save(transaction);
                    }
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }

    public Status bookSeats(TransactionDto transactionDto, BookMeBusDto bookMeBusDto) {
        Status statusResponse = null;
        Transaction savedTransaction = new Transaction();
        try {
            if (TokenGenerator.token == null) {
                try {
                    statusResponse = bookMeIntegrationClient.bookSeats(tokenGenerator.getTokenFromAuthService(), bookMeBusDto);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            } else {
                statusResponse = bookMeIntegrationClient.bookSeats(TokenGenerator.token, bookMeBusDto);
            }
        } catch (FeignException.Unauthorized e) {
            try {
                statusResponse = bookMeIntegrationClient.bookSeats(tokenGenerator.getTokenFromAuthService(), bookMeBusDto);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("statusResponse.getAdditionalDetail() " + statusResponse.getAdditionalDetail());
        if(statusResponse.getAdditionalDetail() != null) {
            try {
                ArrayNode arrayNode = Utils.parseToObject(Utils.parseObjectToJson(statusResponse.getAdditionalDetail()), ArrayNode.class);
                Transaction transaction = TransactionDto.convertToEntity(transactionDto);
                for (JsonNode jsonNode : arrayNode) {
                    if(jsonNode.get("status").asText().equalsIgnoreCase("success")) {
                        transaction.setDescription(jsonNode.get("booking_id").asText());
                        transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                        TransactionDto transactionDtoToReturn = Transaction.convertToDto(savedTransaction);
                        return new Status(StatusMessage.SUCCESS, transactionDtoToReturn);
                    } else {
                        transaction.setDescription(jsonNode.get("message").asText());
                        transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                    }
                    savedTransaction = transactionService.save(transaction);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new Status(StatusMessage.FAILURE, savedTransaction);
    }
}
