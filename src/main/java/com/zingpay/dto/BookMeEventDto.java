package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 03-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BookMeEventDto {
    @JsonProperty("api_key")
    private String apiKey;
    @JsonProperty("tickets")
    private int ticket;
    private String date;
    @JsonProperty("event_id")
    private int eventId;
    private int amount;
    private String name;
    private String phone;
    private String email;
    private ArrayNode passes;

    public static BookMeEventDto convertToDto(BookMeEventRequestDto bookMeEventRequestDto) {
        BookMeEventDto bookMeEventDto = new BookMeEventDto();
        bookMeEventDto.setAmount(bookMeEventRequestDto.getAmount().intValue());
        bookMeEventDto.setDate(bookMeEventRequestDto.getDate());
        bookMeEventDto.setTicket(bookMeEventRequestDto.getTickets());
        bookMeEventDto.setEventId(bookMeEventRequestDto.getEventId());
        bookMeEventDto.setName(bookMeEventRequestDto.getName());
        bookMeEventDto.setPhone(bookMeEventRequestDto.getRefTo());
        bookMeEventDto.setEmail(bookMeEventRequestDto.getEmail());
        bookMeEventDto.setPasses(bookMeEventRequestDto.getPasses());

        return bookMeEventDto;
    }
}
