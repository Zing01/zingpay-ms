package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zingpay.util.ChannelType;
import com.zingpay.util.TransactionType;
import com.zingpay.util.Utils;
import com.zingpay.util.ZingpayTransactionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Bilal Hassan on 05-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BookMeBusRequestDto {
    private int accountId;
    private int serviceId;
    private Double amount;
    private String serviceProvider;
    private String retailerRefNumber;
    private String refTo;
    private Date dateTime;
    private String bundleId;

    private int tickets;
    private int originCityId;
    private int arrivalCityId;
    private String date;
    private String depTime;
    private int timeId;
    private int scheduleId;
    private int routeId;
    private int numberOfSeats;
    private int ticketPrice;
    private int totalPrice;
    private String seatNumbersMale;
    private String seatNumbersFemale;
    private String name;
    private String email;
    @JsonProperty("service_id")
    private int busServiceId;

    public static TransactionDto populateTransactionDtoFields(BookMeBusRequestDto bookMeBusRequestDto) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(bookMeBusRequestDto.getAccountId());
        transactionDto.setServiceId(bookMeBusRequestDto.getServiceId());
        transactionDto.setAmount(bookMeBusRequestDto.getAmount());
        transactionDto.setServiceProvider(bookMeBusRequestDto.getServiceProvider());

        if(bookMeBusRequestDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(bookMeBusRequestDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }

        transactionDto.setRefTo(bookMeBusRequestDto.getRefTo());
        transactionDto.setBundleId(bookMeBusRequestDto.getBundleId());
        transactionDto.setDateTime(bookMeBusRequestDto.getDateTime());
        transactionDto.setEmail(bookMeBusRequestDto.getEmail());
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);
        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        transactionDto.setRetailerRefNumber(bookMeBusRequestDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        return transactionDto;
    }
}
