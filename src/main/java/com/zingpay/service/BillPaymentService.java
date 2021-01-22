package com.zingpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.BillPaymentDto;
import com.zingpay.dto.BillPaymentResponseDto;
import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.BillPaymentIntegrationClient;
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
 * @author Bilal Hassan on 22-Jan-21
 * @project zingpay-ms
 */

@Service
@Transactional
public class BillPaymentService {


    @Autowired
    private BillPaymentIntegrationClient billPaymentIntegrationClient;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private TransactionService transactionService;


    public Status performNadraBillPayment(TransactionDto transactionDto) {
        BillPaymentDto billPaymentDto = BillPaymentDto.convertTransactionToDto(transactionDto);
        Status statusResponse = null;
        Transaction savedTransaction = new Transaction();
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
                Transaction transaction = TransactionDto.convertToEntity(transactionDto);
                if(billPaymentResponseDto != null) {
                    if(billPaymentResponseDto.getStatus().equals("ok")) {
                        transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                        transaction.setDescription(billPaymentResponseDto.getStatus());
                        savedTransaction = transactionService.save(transaction);
                        return new Status(StatusMessage.SUCCESS, savedTransaction);
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
}
