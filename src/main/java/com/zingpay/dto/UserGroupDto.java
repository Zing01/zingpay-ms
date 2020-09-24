package com.zingpay.dto;

import com.zingpay.entity.UserGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 9/23/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class UserGroupDto {
    private int userGroupId;
    private String name;
    private String type;
    private long effectiveStartDate;
    private long effectiveEndDate;
    private int activeInd;

    public static UserGroup convertToEntity(UserGroupDto userGroupDto) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserGroupId(userGroupDto.getUserGroupId());
        userGroup.setName(userGroupDto.getName());
        userGroup.setType(userGroupDto.getType());
        userGroup.setEffectiveStartDate(userGroupDto.getEffectiveStartDate());
        userGroup.setEffectiveEndDate(userGroupDto.getEffectiveEndDate());
        userGroup.setActiveInd(userGroupDto.getActiveInd());
        return userGroup;
    }

    public static List<UserGroup> convertToEntity(List<UserGroupDto> userGroupDtos) {
        List<UserGroup> userGroups = new ArrayList<UserGroup>();
        userGroupDtos.forEach(userGroupDto -> {
            userGroups.add(convertToEntity(userGroupDto));
        });
        return userGroups;
    }
}
