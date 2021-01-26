package com.zingpay.dto;

import com.zingpay.entity.Transaction;
import com.zingpay.util.*;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bilal Hassan on 26-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class TransactionCashDepositDto {
    /*
    private long serviceId; //need to discuss
    private String retailerRefNumber; //need to discuss
    private Double cashDepositAmount;
    private String serviceProvider; //need to discuss
    private String description; //need to discuss
    private String cashDepositRefNumber; //need to discuss
    private String recipientUsername;*/

    @JsonIgnore
    private int accountId;
    @JsonIgnore
    private long serviceId;
    private Double cashDepositAmount;
    private PaymentType paymentType;
    private String cashDepositRefNumber;
    private String recipientUsername;

    public static Transaction convertToEntity(TransactionCashDepositDto transactionCashDepositDto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(transactionCashDepositDto.getAccountId());
        transaction.setServiceId(transactionCashDepositDto.getServiceId());
        transaction.setTransactionTypeId(TransactionType.CREDIT.getId());
        transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
        transaction.setZingpayTransactionTypeId(ZingpayTransactionType.TX_CASH_IN.getId());
        transaction.setChannelTypeId(ChannelType.MOBILE.getId());
        transaction.setRetailerRefNumber(transactionCashDepositDto.getCashDepositRefNumber());
        transaction.setAmount(transactionCashDepositDto.getCashDepositAmount());
        transaction.setServiceProvider("");
        transaction.setDescription(transactionCashDepositDto.getPaymentType().getDescription());
        transaction.setRefFrom(transactionCashDepositDto.getCashDepositRefNumber());
        transaction.setRefTo(transactionCashDepositDto.getRecipientUsername());
        transaction.setDateTime(new Date());

        return transaction;
    }

    public static List<Transaction> convertToEntity(List<TransactionCashDepositDto> transactionCashDepositDtos) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactionCashDepositDtos.forEach(transactionCashDepositDto -> {
            transactions.add(convertToEntity(transactionCashDepositDto));
        });
        return transactions;
    }
}
