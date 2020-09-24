/*
package com.zingpay.dto;

import com.zingpay.entity.Authority;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @author Bilal Hassan on 9/21/2020
 * @project zingpay-ms
 *//*


@Getter
@Setter
public class AuthorityDto {
    private long id;
    private String name;
    private String description;

    public static Authority convertToEntity(AuthorityDto authorityDto) {
        Authority authority = new Authority();
        authority.setId(authorityDto.getId());
        authority.setName(authorityDto.getName());
        authority.setDescription(authorityDto.getDescription());
        return authority;
    }

    public static List<Authority> convertToEntity(List<AuthorityDto> authorityDtos) {
        List<Authority> authorities = new ArrayList<>();
        authorityDtos.forEach(authorityDto -> {
            authorities.add(convertToEntity(authorityDto));
        });
        return authorities;
    }
}
*/
