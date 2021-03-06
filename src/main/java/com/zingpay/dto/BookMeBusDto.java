package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 05-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BookMeBusDto {
    @JsonProperty("api_key")
    private String apiKey;

    @JsonProperty("service_id")
    private long serviceId;

    @JsonProperty("origin_city_id")
    private int originCityId;

    @JsonProperty("arrival_city_id")
    private int arrivalCityId;

    private String date;
    @JsonProperty("deptime")
    private String depTime;
    @JsonProperty("time_id")
    private int timeId;
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("route_id")
    private int routeId;
    @JsonProperty("number_of_seats")
    private int numberOfSeats;
    private String name;
    private String phone;
    @JsonProperty("ticket_price")
    private int ticketPrice;
    @JsonProperty("seat_numbers_male")
    private String seatNumbersMale;
    @JsonProperty("seat_numbers_female")
    private String seatNumbersFemale;
    private String email;
    @JsonProperty("service_id")
    private int busServiceId;

    public static BookMeBusDto convertToDto(BookMeBusRequestDto bookMeBusRequestDto) {
        BookMeBusDto bookMeBusDto = new BookMeBusDto();
        bookMeBusDto.setServiceId(bookMeBusRequestDto.getServiceId());
        bookMeBusDto.setOriginCityId(bookMeBusRequestDto.getOriginCityId());
        bookMeBusDto.setArrivalCityId(bookMeBusRequestDto.getArrivalCityId());
        bookMeBusDto.setDate(bookMeBusRequestDto.getDate());
        bookMeBusDto.setDepTime(bookMeBusRequestDto.getDepTime());
        bookMeBusDto.setTimeId(bookMeBusRequestDto.getTimeId());
        bookMeBusDto.setScheduleId(bookMeBusRequestDto.getScheduleId());
        bookMeBusDto.setRouteId(bookMeBusRequestDto.getRouteId());
        bookMeBusDto.setNumberOfSeats(bookMeBusRequestDto.getNumberOfSeats());
        bookMeBusDto.setName(bookMeBusRequestDto.getName());
        bookMeBusDto.setPhone(bookMeBusRequestDto.getRefTo());
        bookMeBusDto.setTicketPrice(bookMeBusRequestDto.getTicketPrice());
        bookMeBusDto.setSeatNumbersMale(bookMeBusRequestDto.getSeatNumbersMale());
        bookMeBusDto.setSeatNumbersFemale(bookMeBusRequestDto.getSeatNumbersFemale());
        bookMeBusDto.setEmail(bookMeBusRequestDto.getEmail());
        bookMeBusDto.setBusServiceId(bookMeBusRequestDto.getBusServiceId());

        return bookMeBusDto;
    }
}
