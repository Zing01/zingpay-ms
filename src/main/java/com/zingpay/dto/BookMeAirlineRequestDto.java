package com.zingpay.dto;

import com.zingpay.util.ChannelType;
import com.zingpay.util.TransactionType;
import com.zingpay.util.Utils;
import com.zingpay.util.ZingpayTransactionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Bilal Hassan on 10-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BookMeAirlineRequestDto {
    private int accountId;
    private int serviceId;
    private Double amount;
    private String serviceProvider;
    private String retailerRefNumber;
    private String refTo;
    private Date dateTime;
    private String bundleId;

    private String apiKey;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfInfants;
    private String refId;
    private String journeyRefId;
    private String[] travelerType;
    private String[] prefix;
    private String[] firstName;
    private String[] lastName;
    private String[] gender;
    private int[] age;
    private String[] dob;
    private String[] seat;
    private String[] passsengerCountry;
    private String[] nationality;
    private String[] passportNumber;
    private String[] passportExpiry;
    private String addressName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String areaCode;
    private String countryCode;
    private String location;
    private String phoneNumber;
    private String email;
    private String cnic;

    public static TransactionDto populateTransactionDtoFields(BookMeAirlineRequestDto bookMeAirlineRequestDto) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(bookMeAirlineRequestDto.getAccountId());
        transactionDto.setServiceId(bookMeAirlineRequestDto.getServiceId());
        transactionDto.setAmount(bookMeAirlineRequestDto.getAmount());
        transactionDto.setServiceProvider(bookMeAirlineRequestDto.getServiceProvider());

        if(bookMeAirlineRequestDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(bookMeAirlineRequestDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }

        transactionDto.setRefTo(bookMeAirlineRequestDto.getRefTo());
        transactionDto.setBundleId(bookMeAirlineRequestDto.getBundleId());
        transactionDto.setDateTime(bookMeAirlineRequestDto.getDateTime());
        transactionDto.setEmail(bookMeAirlineRequestDto.getEmail());
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);
        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        transactionDto.setRetailerRefNumber(bookMeAirlineRequestDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        return transactionDto;
    }
}
