package com.zingpay.entity;

import com.zingpay.dto.AuthorityDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 9/21/2020
 * @project zingpay-ms
 */

@Entity
@Table(name = "authority")
@Getter
@Setter
public class Authority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public static AuthorityDto convertToDto(Authority authority) {
        AuthorityDto authorityDto = new AuthorityDto();
        authorityDto.setId(authority.getId());
        authorityDto.setName(authority.getName());
        authorityDto.setDescription(authority.getDescription());
        return authorityDto;
    }

    public static List<AuthorityDto> convertToDto(List<Authority> authorities) {
        List<AuthorityDto> authorityDtos = new ArrayList<>();
        authorities.forEach(authority -> {
            authorityDtos.add(convertToDto(authority));
        });
        return authorityDtos;
    }
}
