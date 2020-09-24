/*
package com.zingpay.dto;

import com.zingpay.entity.Authority;
import com.zingpay.entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.LazyInitializationException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

*/
/**
 * @author Bilal Hassan on 9/21/2020
 * @project zingpay-ms
 *//*


@Getter
@Setter
public class RoleDto {
    private long id;
    private String name;
    private String descrition;
    private List<AuthorityDto> authorities;

    public static Role convertToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescrition());
        try {
            if(roleDto.getAuthorities() != null) {
                role.setAuthorities(new HashSet<Authority>(AuthorityDto.convertToEntity(roleDto.getAuthorities())));
            }
        } catch (LazyInitializationException e) {

        }
        return role;
    }

    public static List<Role> convertToEntity(List<RoleDto> roleDtos) {
        List<Role> roles = new ArrayList<>();
        roleDtos.forEach(roleDto -> {
            roles.add(convertToEntity(roleDto));
        });
        return roles;
    }
}
*/
