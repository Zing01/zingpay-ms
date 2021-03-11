package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 10-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BookMeAirlineDto {

    @JsonProperty("no_of_adults")
    private int numberOfAdults;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("no_of_children")
    private int numberOfChildren;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("no_of_infants")
    private int numberOfInfants;

    @JsonProperty("ref_id")
    private String refId;

    @JsonProperty("journey_ref_id")
    private String journeyRefId;

    @JsonProperty("traveler_type[]")
    private String[] travelerType;

    @JsonProperty("prefix[]")
    private String[] prefix;

    @JsonProperty("firstname[]")
    private String[] firstName;

    @JsonProperty("lastname[]")
    private String[] lastName;

    @JsonProperty("gender[]")
    private String[] gender;

    @JsonProperty("age[]")
    private int[] age;

    @JsonProperty("dob[]")
    private String[] dob;

    @JsonProperty("seat[]")
    private String[] seat;

    @JsonProperty("passenger_country[]")
    private String[] passsengerCountry;

    @JsonProperty("nationality[]")
    private String[] nationality;

    @JsonProperty("passport_no[]")
    private String[] passportNumber;

    @JsonProperty("passport_expiry[]")
    private String[] passportExpiry;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("address_name")
    private String addressName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String street;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String state;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("postal_code")
    private String postalCode;

    private String country;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("area_code")
    private String areaCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("country_code")
    private String countryCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String location;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cnic;

    public static BookMeAirlineDto convertToDto(BookMeAirlineRequestDto bookMeAirlineRequestDto) {
        BookMeAirlineDto bookMeAirlineDto = new BookMeAirlineDto();
        bookMeAirlineDto.setNumberOfAdults(bookMeAirlineRequestDto.getNumberOfAdults());
        bookMeAirlineDto.setNumberOfChildren(bookMeAirlineRequestDto.getNumberOfChildren());
        bookMeAirlineDto.setNumberOfInfants(bookMeAirlineRequestDto.getNumberOfInfants());
        bookMeAirlineDto.setRefId(bookMeAirlineRequestDto.getRefId());
        bookMeAirlineDto.setJourneyRefId(bookMeAirlineRequestDto.getJourneyRefId());
        bookMeAirlineDto.setTravelerType(bookMeAirlineRequestDto.getTravelerType());
        bookMeAirlineDto.setPrefix(bookMeAirlineRequestDto.getPrefix());
        bookMeAirlineDto.setFirstName(bookMeAirlineRequestDto.getFirstName());
        bookMeAirlineDto.setLastName(bookMeAirlineRequestDto.getLastName());
        bookMeAirlineDto.setGender(bookMeAirlineRequestDto.getGender());

        return bookMeAirlineDto;
    }
}
