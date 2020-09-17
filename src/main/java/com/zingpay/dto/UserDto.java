package com.zingpay.dto;


import com.zingpay.entity.User;
import com.zingpay.util.AgentType;
import com.zingpay.util.HouseType;
import com.zingpay.util.PlaceType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@Getter
@Setter
public class UserDto {
    private long id;
    private String mobileNumber;
    private String smsPin;
    private String cnic;
    private String email;
    private String emailPin;
    private String fullName;
    private String password;
    private String confirmPassword;

    private String securityCode;
    private boolean active;

    private String picture;
    private String personName;
    private PlaceType placeType;
    private AgentType agentType;
    private String address;
    private HouseType houseType;
    private String location;
    private String cnicF;
    private String cnicB;
    private String otherAttachment;
    private String tPin;

    public static User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setSmsPin(userDto.getSmsPin());
        user.setCnic(userDto.getCnic());
        user.setEmail(userDto.getEmail());
        user.setSecurityCode(userDto.getSecurityCode());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        user.setEmailPin(userDto.getEmailPin());

        user.setActive(userDto.isActive());
        user.setTPin(userDto.getTPin());

        if(userDto.getPicture() != null) {
            user.setPicture(userDto.getPicture());
        }

        if(userDto.getPersonName() != null) {
            user.setPersonName(userDto.getPersonName());
        }

        if(userDto.getPlaceType() != null) {
            user.setPlaceType(userDto.getPlaceType().name());
        }

        if(userDto.getAgentType() != null) {
            user.setAgentType(userDto.getAgentType().name());
        }

        if(userDto.getAddress() != null) {
            user.setAddress(userDto.getAddress());
        }

        if(userDto.getHouseType() != null) {
            user.setHouseType(userDto.getHouseType().name());
        }

        if(userDto.getLocation() != null) {
            user.setLocation(userDto.getLocation());
        }

        if(userDto.getCnicB() != null) {
            user.setCnicB(userDto.getCnicB());
        }

        if(userDto.getCnicF() != null) {
            user.setCnicF(userDto.getCnicF());
        }

        if(userDto.getOtherAttachment() != null) {
            user.setOtherAttachment(userDto.getOtherAttachment());
        }

        return user;
    }

    public static List<User> convertToEntity(List<UserDto> userDtos) {
        List<User> users = new ArrayList<User>();
        userDtos.forEach(userDto -> {
            users.add(convertToEntity(userDto));
        });
        return users;
    }
}
