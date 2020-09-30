package com.zingpay.dto;

import com.zingpay.entity.Transaction;
import com.zingpay.util.TransactionStatus;
import com.zingpay.util.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class TransactionDto {
    private long id;
    private long accountId;
    private long serviceId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private long oneLoadTransactionTypeId;
    private Double amount;
    private String retailerNetwork;
    private String serviceProvider;
    private String description;
    private String refFrom;
    private String refTo;
    private long dateTime;

    public static Transaction convertToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setServiceId(transactionDto.getServiceId());
        transaction.setTransactionStatusId(transactionDto.getTransactionStatus().getId());
        transaction.setTransactionTypeId(transactionDto.getTransactionType().getId());
        transaction.setOneLoadTransactionTypeId(transactionDto.getOneLoadTransactionTypeId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setRetailerNetwork(transactionDto.getRetailerNetwork());
        transaction.setServiceProvider(transactionDto.getServiceProvider());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setRefFrom(transactionDto.getRefFrom());
        transaction.setRefTo(transactionDto.getRefTo());
        transaction.setDateTime(transactionDto.getDateTime());

        return transaction;
    }

    public static List<Transaction> convertToEntity(List<TransactionDto> transactionDtos) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactionDtos.forEach(transactionDto -> {
            transactions.add(convertToEntity(transactionDto));
        });
        return transactions;
    }
}
