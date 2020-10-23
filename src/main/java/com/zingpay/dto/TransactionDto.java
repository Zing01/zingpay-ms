package com.zingpay.dto;

import com.zingpay.entity.Transaction;
import com.zingpay.util.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
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
    private ZingpayTransactionType zingpayTransactionType;
    private ChannelType channelType;
    private String retailerRefNumber;
    private Double amount;
    private String serviceProvider;
    private String description;
    private String refFrom;
    private String refTo;
    private Date dateTime;
    private Double transactionTotal;
    private long transactionCount;

    public static Transaction convertToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setServiceId(transactionDto.getServiceId());
        if(transactionDto.getTransactionStatus() != null) {
            transaction.setTransactionStatusId(transactionDto.getTransactionStatus().getId());
        }
        if(transactionDto.getTransactionType() != null) {
            transaction.setTransactionTypeId(transactionDto.getTransactionType().getId());
        }
        if(transactionDto.getZingpayTransactionType() != null) {
            transaction.setZingpayTransactionTypeId(transactionDto.getZingpayTransactionType().getId());
        }
        if(transactionDto.getChannelType() != null) {
            transaction.setChannelTypeId(transactionDto.getChannelType().getId());
        }
        transaction.setRetailerRefNumber(transactionDto.getRetailerRefNumber());
        transaction.setAmount(transactionDto.getAmount());
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

    public static TransactionDto convertHistoryToDto(Object transaction) {
        TransactionDto transactionDto = new TransactionDto();
        Object[] objArray = (Object[]) transaction;
        //transactionId
        transactionDto.setId(Long.parseLong(objArray[0].toString()));
        //accountId
        transactionDto.setAccountId(Long.parseLong(objArray[1].toString()));
        //transactionStatusId
        if(Long.parseLong(objArray[2].toString()) == 1) {
            transactionDto.setTransactionStatus(TransactionStatus.SUCCESS);
        } else if(Long.parseLong(objArray[2].toString()) == 2) {
            transactionDto.setTransactionStatus(TransactionStatus.FAILED);
        } else if(Long.parseLong(objArray[2].toString()) == 3) {
            transactionDto.setTransactionStatus(TransactionStatus.PENDING);
        }
        //transactionTypeId
        if(Long.parseLong(objArray[3].toString()) == 1) {
            transactionDto.setTransactionType(TransactionType.DEBIT);
        } else if(Long.parseLong(objArray[3].toString()) == 2) {
            transactionDto.setTransactionType(TransactionType.CREDIT);
        }
        //zingpayTransactionType
        if(Long.parseLong(objArray[4].toString()) == 1) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_RECHARGE);
        } else if(Long.parseLong(objArray[4].toString()) == 2) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_FUND_TRANSFER);
        } else if(Long.parseLong(objArray[4].toString()) == 3) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BUY);
        } else if(Long.parseLong(objArray[4].toString()) == 4) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BILL_PAYMENT);
        } else if(Long.parseLong(objArray[4].toString()) == 5) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_COMMISSION);
        } else if(Long.parseLong(objArray[4].toString()) == 6) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_SERVICE_CHARGE);
        } else if(Long.parseLong(objArray[4].toString()) == 7) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        } else if(Long.parseLong(objArray[4].toString()) == 8) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_CASH_IN);
        }
        //retailer_ref_num
        //provider_ref_num
        //amount
        transactionDto.setAmount(Double.parseDouble(objArray[7].toString()));
        //service_provider
        transactionDto.setServiceProvider(objArray[8].toString());
        //description
        if(objArray[9] != null) {
            transactionDto.setDescription(objArray[9].toString());
        }
        //ref_from
        transactionDto.setRefFrom(objArray[10].toString());
        //ref_to
        transactionDto.setRefTo(objArray[11].toString());
        //datetime
        transactionDto.setDateTime(Utils.getFormattedDate(objArray[14].toString()));
        //service_id
        transactionDto.setServiceId(Long.parseLong(objArray[15].toString()));

        return transactionDto;
    }

    public static List<TransactionDto> convertHistoryToDto(List<Object> transactions) {
        List<TransactionDto> transactionDtos = new ArrayList<TransactionDto>();
        transactions.forEach(transaction -> {
            transactionDtos.add(convertHistoryToDto(transaction));
        });
        return transactionDtos;
    }

    public static TransactionDto convertSummaryToDto(Object transaction) {
        TransactionDto transactionDto = new TransactionDto();
        Object[] objArray = (Object[]) transaction;
        //transactionStatusId
        if(Long.parseLong(objArray[0].toString()) == 1) {
            transactionDto.setTransactionStatus(TransactionStatus.SUCCESS);
        } else if(Long.parseLong(objArray[0].toString()) == 2) {
            transactionDto.setTransactionStatus(TransactionStatus.FAILED);
        } else if(Long.parseLong(objArray[0].toString()) == 3) {
            transactionDto.setTransactionStatus(TransactionStatus.PENDING);
        }
        //transactionTypeId
        if(Long.parseLong(objArray[1].toString()) == 1) {
            transactionDto.setTransactionType(TransactionType.DEBIT);
        } else if(Long.parseLong(objArray[1].toString()) == 2) {
            transactionDto.setTransactionType(TransactionType.CREDIT);
        }
        //zingpayTransactionType
        if(Long.parseLong(objArray[2].toString()) == 1) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_RECHARGE);
        } else if(Long.parseLong(objArray[2].toString()) == 2) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_FUND_TRANSFER);
        } else if(Long.parseLong(objArray[2].toString()) == 3) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BUY);
        } else if(Long.parseLong(objArray[2].toString()) == 4) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BILL_PAYMENT);
        } else if(Long.parseLong(objArray[2].toString()) == 5) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_COMMISSION);
        } else if(Long.parseLong(objArray[2].toString()) == 6) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_SERVICE_CHARGE);
        } else if(Long.parseLong(objArray[2].toString()) == 7) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        } else if(Long.parseLong(objArray[2].toString()) == 8) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_CASH_IN);
        }
        //transactionsTotal
        transactionDto.setTransactionTotal(Double.parseDouble(objArray[3].toString()));
        //transactionCount
        transactionDto.setTransactionCount(Long.parseLong(objArray[4].toString()));

        return transactionDto;
    }

    public static List<TransactionDto> convertSummaryToDto(List<Object> transactions) {
        List<TransactionDto> transactionDtos = new ArrayList<TransactionDto>();
        transactions.forEach(transaction -> {
            transactionDtos.add(convertSummaryToDto(transaction));
        });
        return transactionDtos;
    }
}
