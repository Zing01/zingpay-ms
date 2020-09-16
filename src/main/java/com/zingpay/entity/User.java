package com.zingpay.entity;

import com.zingpay.dto.UserDto;
import com.zingpay.util.AgentType;
import com.zingpay.util.HouseType;
import com.zingpay.util.PlaceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@Getter
@Setter
@Table(name = "app_user")
@Entity
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="fullName")
    private String fullName;
    @Column(name="mobileNumber")
    private String mobileNumber;
    @Column(name="smsPin")
    private String smsPin;
    @Column(name="password")
    private String password;
    @Column(name="cnic")
    private String cnic;
    @Column(name="email")
    private String email;
    @Column(name="emailPin")
    private String emailPin;

    @Column(name="active")
    private boolean active;

    @Column(name="securityCode")
    private String securityCode;

    @Column(name="picture")
    private String picture;
    @Column(name="personName")
    private String personName;
    @Column(name="placeType")
    private String placeType;
    @Column(name="agentType")
    private String agentType;
    @Column(name="address")
    private String address;
    @Column(name="houseType")
    private String houseType;
    @Column(name="location")
    private String location;
    @Column(name="CNICF")
    private String cnicF;
    @Column(name="CNICB")
    private String cnicB;
    @Column(name="otherAttachment")
    private String otherAttachment;

    public static UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setCnic(user.getCnic());
        userDto.setEmail(user.getEmail());
        userDto.setSecurityCode(user.getSecurityCode());
        userDto.setFullName(user.getFullName());
        userDto.setPassword(user.getPassword());

        if(user.getPicture() != null) {
            userDto.setPicture(user.getPicture());
        }

        if(user.getPersonName() != null) {
            userDto.setPersonName(user.getPersonName());
        }

        if(user.getPlaceType() != null) {
            if(user.getPlaceType().equals("HOUSE")) {
                userDto.setPlaceType(PlaceType.HOUSE);
            } else if(user.getPlaceType().equals("SHOP")) {
                userDto.setPlaceType(PlaceType.SHOP);
            }
        }

        if(user.getAgentType() != null) {
            if(user.getAgentType().equals("VIRTUAL_AGENT")) {
                userDto.setAgentType(AgentType.VIRTUAL_AGENT);
            } else if(user.getAgentType().equals("RETAILER")) {
                userDto.setAgentType(AgentType.RETAILER);
            }
        }

        if(user.getAddress() != null) {
            userDto.setAddress(user.getAddress());
        }

        if(user.getHouseType() != null) {
            if(user.getHouseType().equals("OWNED")) {
                userDto.setHouseType(HouseType.OWNED);
            } else if(user.getHouseType().equals("RENT")) {
                userDto.setHouseType(HouseType.RENT);
            }
        }

        if(user.getLocation() != null) {
            userDto.setLocation(user.getLocation());
        }

        if(user.getCnicB() != null) {
            userDto.setCnicB(user.getCnicB());
        }

        if(user.getCnicF() != null) {
            userDto.setCnicF(user.getCnicF());
        }

        if(user.getOtherAttachment() != null) {
            userDto.setOtherAttachment(user.getOtherAttachment());
        }

        return userDto;
    }

    public static List<UserDto> convertToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        users.forEach(user -> {
            userDtos.add(convertToDto(user));
        });
        return userDtos;
    }
}
