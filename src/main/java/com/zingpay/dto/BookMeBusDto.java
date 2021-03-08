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

    @JsonProperty("service_id")
    private int busServiceId;
    @JsonProperty("origin_city_id")
    private int originCityId;
    @JsonProperty("destination_city_id")
    private int destinationCityId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("deptime")
    private String departureTime;
    @JsonProperty("depdate")
    private String depDate;
    @JsonProperty("time_id")
    private int timeId;
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("route_id")
    private int routeId;
    @JsonProperty("seats")
    private int seats;
    @JsonProperty("no_of_seats")
    private int noOfSeats;
    @JsonProperty("seat_ids")
    private String seatIds;
    @JsonProperty("arrival_city_id")
    private int arrivalCityId;
    @JsonProperty("departure_city_id")
    private int departureCityId;
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
    @JsonProperty("total_price")
    private int totalPrice;
    private int tickets;

    public static BookMeBusDto convertToDto(BookMeBusRequestDto bookMeBusRequestDto) {
        BookMeBusDto bookMeBusDto = new BookMeBusDto();
        bookMeBusDto.setBusServiceId(bookMeBusRequestDto.getBusServiceId());
        bookMeBusDto.setOriginCityId(bookMeBusRequestDto.getOriginCityId());
        bookMeBusDto.setArrivalCityId(bookMeBusRequestDto.getArrivalCityId());
        bookMeBusDto.setDate(bookMeBusRequestDto.getDate());
        bookMeBusDto.setDepartureTime(bookMeBusRequestDto.getDepTime());
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
        bookMeBusDto.setTotalPrice(bookMeBusRequestDto.getTotalPrice());
        bookMeBusDto.setTickets(bookMeBusRequestDto.getTickets());

        return bookMeBusDto;
    }
}
