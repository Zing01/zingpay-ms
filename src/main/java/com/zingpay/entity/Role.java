/*
package com.zingpay.entity;

import com.zingpay.dto.RoleDto;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

*/
/**
 * @author Bilal Hassan on 9/21/2020
 * @project zingpay-ms
 *//*


@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.REFRESH
    })
    @JoinTable(name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    @JsonManagedReference
    private Set<Authority> authorities;

    public static RoleDto convertToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setDescrition(role.getDescription());
        try {
            if(role.getAuthorities() != null) {
                roleDto.setAuthorities(Authority.convertToDto(role.getAuthorities().stream().collect(Collectors.toList())));
            }
        } catch (LazyInitializationException e) {

        }
        return roleDto;
    }

    public static List<RoleDto> convertToDto(List<Role> roles) {
        List<RoleDto> roleDtos = new ArrayList<>();
        roles.forEach(role -> {
            roleDtos.add(convertToDto(role));
        });
        return roleDtos;
    }
}
*/
