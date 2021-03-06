package com.zingpay.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
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
    private String phone;
    private String email;
    private ArrayNode passes;
}
