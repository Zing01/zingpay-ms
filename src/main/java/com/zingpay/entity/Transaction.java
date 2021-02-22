package com.zingpay.entity;

import com.zingpay.dto.TransactionDto;
import com.zingpay.util.ChannelType;
import com.zingpay.util.TransactionStatus;
import com.zingpay.util.TransactionType;
import com.zingpay.util.ZingpayTransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

@Getter
@Setter
@Table(name = "transaction")
@Entity
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_id")
    private long accountId;

    @Column(name = "service_id")
    private long serviceId;

    @Column(name = "transaction_type_id")
    private long transactionTypeId;

    @Column(name = "transaction_status_id")
    private long transactionStatusId;

    @Column(name = "zingpay_transaction_type_id")
    private long zingpayTransactionTypeId;

    @Column(name = "channel_type_id")
    private long channelTypeId;

    @Column(name = "retailer_ref_num")
    private String retailerRefNumber;

    @Column(name = "amount")
    private double amount;

    @Column(name = "retailer_network")
    private String retailerNetwork;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "description")
    private String description;

    @Column(name = "ref_from")
    private String refFrom;

    @Column(name = "ref_to")
    private String refTo;

    @Column(name = "datetime")
    private Date dateTime;

    @Column(name = "billing_month")
    private String billingMonth;

    public static TransactionDto convertToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAccountId(transaction.getAccountId());
        transactionDto.setServiceId(transaction.getServiceId());

        if(transaction.getTransactionStatusId() == TransactionStatus.SUCCESS.getId()) {
            transactionDto.setTransactionStatus(TransactionStatus.SUCCESS);
        } else if(transaction.getTransactionStatusId() == TransactionStatus.FAILED.getId()) {
            transactionDto.setTransactionStatus(TransactionStatus.FAILED);
        } else if(transaction.getTransactionStatusId() == TransactionStatus.PENDING.getId()) {
            transactionDto.setTransactionStatus(TransactionStatus.PENDING);
        }

        if(transaction.getTransactionTypeId() == TransactionType.DEBIT.getId()) {
            transactionDto.setTransactionType(TransactionType.DEBIT);
        } else if(transaction.getTransactionTypeId() == TransactionType.CREDIT.getId()) {
            transactionDto.setTransactionType(TransactionType.CREDIT);
        }

        if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_RECHARGE.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_RECHARGE);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_FUND_TRANSFER.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_FUND_TRANSFER);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_BUY.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BUY);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_BILL_PAYMENT.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BILL_PAYMENT);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_COMMISSION.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_COMMISSION);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_SERVICE_CHARGE.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_SERVICE_CHARGE);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_LOAD.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        } else if(transaction.getZingpayTransactionTypeId() == ZingpayTransactionType.TX_CASH_IN.getId()) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_CASH_IN);
        }

        if(transaction.getChannelTypeId() == ChannelType.MOBILE.getId()) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(transaction.getChannelTypeId() == ChannelType.WEB.getId()) {
            transactionDto.setChannelType(ChannelType.WEB);
        }

        transactionDto.setRetailerRefNumber(transaction.getRetailerRefNumber());
        transactionDto.setAmount(transaction.getAmount());
        //transactionDto.setRetailerNetwork(transaction.getRetailerNetwork());
        transactionDto.setServiceProvider(transaction.getServiceProvider());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setRefFrom(transaction.getRefFrom());
        transactionDto.setRefTo(transaction.getRefTo());
        transactionDto.setDateTime(transaction.getDateTime());
        transactionDto.setBillingMonth(transaction.getBillingMonth());

        return transactionDto;
    }

    public static List<TransactionDto> convertToDto(List<Transaction> transactions) {
        List<TransactionDto> transactionDtos = new ArrayList<TransactionDto>();
        transactions.forEach(transaction -> {
            transactionDtos.add(convertToDto(transaction));
        });
        return transactionDtos;
    }
}
