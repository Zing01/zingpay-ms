package com.zingpay.dto;

import com.zingpay.entity.Transaction;
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
public class TransactionResponseDto {
    //private TransactionType transactionType;
    //private TransactionStatus transactionStatus;
    private double amount;
    private long transactionTypeId;
    private long transactionStatusId;

    public TransactionResponseDto(double amount, long transactionStatusId, long transactionTypeId) {
        this.amount = amount;
        this.transactionStatusId = transactionStatusId;
        this.transactionTypeId = transactionTypeId;
    }

    public TransactionResponseDto() {

    }

    public static TransactionResponseDto convertToDto(Transaction transaction) {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setAmount(transaction.getAmount());
        /*if(transaction.getTransactionStatusId() == 1) {
            transactionResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        } else if(transaction.getTransactionStatusId() == 2) {
            transactionResponseDto.setTransactionStatus(TransactionStatus.FAILED);
        } else if(transaction.getTransactionStatusId() == 3) {
            transactionResponseDto.setTransactionStatus(TransactionStatus.PENDING);
        }

        if(transaction.getTransactionTypeId() == 1) {
            transactionResponseDto.setTransactionType(TransactionType.DEBIT);
        } else if(transaction.getTransactionTypeId() == 2) {
            transactionResponseDto.setTransactionType(TransactionType.CREDIT);
        }*/
        transactionResponseDto.setTransactionStatusId(transaction.getTransactionStatusId());
        transactionResponseDto.setTransactionTypeId(transaction.getTransactionTypeId());

        return transactionResponseDto;
    }

    public static List<TransactionResponseDto> convertToDto(List<Transaction> transactions) {
        List<TransactionResponseDto> transactionResponseDtos = new ArrayList<TransactionResponseDto>();
        transactions.forEach(transaction -> {
            transactionResponseDtos.add(convertToDto(transaction));
        });
        return transactionResponseDtos;
    }
}
