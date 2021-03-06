package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
}
