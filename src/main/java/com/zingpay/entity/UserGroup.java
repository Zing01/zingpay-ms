package com.zingpay.entity;

import com.zingpay.dto.UserGroupDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 9/23/2020
 * @project zingpay-ms
 */

@Entity
@Getter
@Setter
@Table(name = "user_group")
public class UserGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_group_id")
    private int userGroupId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "effective_start_date")
    private long effectiveStartDate;

    @Column(name = "effective_end_date")
    private long effectiveEndDate;

    @Column(name = "active_ind")
    private int activeInd;

    public static UserGroupDto convertToDto(UserGroup userGroup) {
        UserGroupDto userGroupDto = new UserGroupDto();
        userGroupDto.setUserGroupId(userGroup.getUserGroupId());
        userGroupDto.setName(userGroup.getName());
        userGroupDto.setType(userGroup.getType());
        userGroupDto.setEffectiveStartDate(userGroup.getEffectiveStartDate());
        userGroupDto.setEffectiveEndDate(userGroup.getEffectiveEndDate());
        userGroupDto.setActiveInd(userGroup.getActiveInd());
        return userGroupDto;
    }

    public static List<UserGroupDto> convertToDto(List<UserGroup> userGroups) {
        List<UserGroupDto> userGroupDtos = new ArrayList<UserGroupDto>();
        userGroups.forEach(userGroup -> {
            userGroupDtos.add(convertToDto(userGroup));
        });
        return userGroupDtos;
    }
}
