package com.zingpay.entity;

import com.zingpay.dto.UserDto;
import com.zingpay.util.AgentType;
import com.zingpay.util.HouseType;
import com.zingpay.util.PlaceType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.LazyInitializationException;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@Getter
@Setter
@Table(name = "app_user")
@Entity
@DynamicUpdate
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="mobile_number")
    private String mobileNumber;
    @Column(name="sms_pin")
    private String smsPin;
    @Column(name="password")
    private String password;
    @Column(name="cnic")
    private String cnic;
    @Column(name="email")
    private String email;
    @Column(name="email_pin")
    private String emailPin;

    @Column(name="active")
    private boolean active;

    @Column(name="security_code")
    private String securityCode;

    @Column(name="picture")
    private String picture;
    @Column(name="person_name")
    private String personName;
    @Column(name="place_type")
    private String placeType;
    @Column(name="agent_type")
    private String agentType;
    @Column(name="address")
    private String address;
    @Column(name="house_type")
    private String houseType;
    @Column(name="location")
    private String location;
    @Column(name="cnicf")
    private String cnicF;
    @Column(name="cnicb")
    private String cnicB;
    @Column(name="other_attachment")
    private String otherAttachment;
    @Column(name="t_pin")
    private String tPin;

    @ManyToMany(cascade = {
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

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

        if(user.getRoles() != null) {
            try {
                userDto.setRoles(Role.convertToDto(user.getRoles().stream().collect(Collectors.toList())));
            } catch (LazyInitializationException e) {

            }
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
