package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 19-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class AppUserDtoForCommission {
    private long accountId;
    private String username;
    private long parentId;
    private long accountTypeId;
    private String groupName;

    public static List<AppUserDtoForCommission> convertToDto(List<Object> objects) {
        List<AppUserDtoForCommission> appUserDtoForCommissions = new ArrayList<AppUserDtoForCommission>();
        objects.forEach(object -> {
            appUserDtoForCommissions.add(convertToDto(object));
        });
        return appUserDtoForCommissions;
    }

    public static AppUserDtoForCommission convertToDto(Object object) {
        AppUserDtoForCommission appUserDtoForCommission = new AppUserDtoForCommission();
        Object[] objArray = (Object[]) object;
        appUserDtoForCommission.setAccountId(Integer.parseInt(objArray[0].toString()));
        appUserDtoForCommission.setUsername(objArray[1].toString());
        appUserDtoForCommission.setAccountTypeId(Long.parseLong(objArray[2].toString()));
        appUserDtoForCommission.setParentId(Integer.parseInt(objArray[3].toString()));
        appUserDtoForCommission.setGroupName(objArray[4].toString());
        return appUserDtoForCommission;
    }
}
