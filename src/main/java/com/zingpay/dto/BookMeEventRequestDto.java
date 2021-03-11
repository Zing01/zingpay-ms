package com.zingpay.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.zingpay.util.ChannelType;
import com.zingpay.util.TransactionType;
import com.zingpay.util.Utils;
import com.zingpay.util.ZingpayTransactionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Bilal Hassan on 03-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BookMeEventRequestDto {
    private int accountId;
    private long serviceId;
    private Double amount;
    private String serviceProvider;
    private String retailerRefNumber;
    private String refTo;
    private Date dateTime;
    private String bundleId;

    private int tickets;
    private String date;
    private int eventId;
    private String paymentType;
    private String address;
    private String city;
    private String name;
    private String email;
    private ArrayNode passes;

    public static TransactionDto populateTransactionDtoFields(BookMeEventRequestDto bookMeEventRequestDto) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(bookMeEventRequestDto.getAccountId());
        transactionDto.setServiceId(bookMeEventRequestDto.getServiceId());
        transactionDto.setAmount(bookMeEventRequestDto.getAmount());
        transactionDto.setServiceProvider(bookMeEventRequestDto.getServiceProvider());

        if(bookMeEventRequestDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(bookMeEventRequestDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }

        transactionDto.setRefTo(bookMeEventRequestDto.getRefTo());
        transactionDto.setBundleId(bookMeEventRequestDto.getBundleId());
        transactionDto.setDateTime(bookMeEventRequestDto.getDateTime());
        transactionDto.setEmail(bookMeEventRequestDto.getEmail());
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);
        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        transactionDto.setRetailerRefNumber(bookMeEventRequestDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        return transactionDto;
    }
}
