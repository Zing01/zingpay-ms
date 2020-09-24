package com.zingpay.dto;

import com.zingpay.entity.AppUser;
import com.zingpay.util.AccountStatus;
import com.zingpay.util.AccountType;
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
public class AppUserDto {
    private int accountId;
    private int parentId;
    private int branchId;
    private int groupId;
    private AccountStatus accountStatusId;
    private AccountType accountTypeId;
    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String address;
    private String cellPhone;
    private String email;
    private String cnicNumber;
    private String alternateCellPhone;
    private long lastLogin;
    private long createDateTime;
    private int createdBy;
    private long modifiedDateTime;
    private int modifiedBy;
    private long suspendDateTime;
    private String tPin;
    private int loginFailedCount;
    private boolean isGeneratedTpin;
    private String smsPin;
    private String emailPin;

    public static AppUser convertToEntity(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        appUser.setAccountId(appUserDto.getAccountId());
        appUser.setAccountStatusId(appUserDto.getAccountStatusId().getId());
        appUser.setAccountTypeId(appUserDto.getAccountTypeId().getId());
        appUser.setAddress(appUserDto.getAddress());
        appUser.setAlternateCellPhone(appUserDto.getAlternateCellPhone());
        appUser.setBranchId(appUserDto.getBranchId());
        appUser.setCellPhone(appUserDto.getCellPhone());
        appUser.setCnicNumber(appUserDto.getCnicNumber());
        appUser.setCreateDateTime(appUserDto.getCreateDateTime());
        appUser.setCreatedBy(appUserDto.getCreatedBy());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setFullName(appUserDto.getFullName());
        appUser.setGeneratedTpin(appUserDto.isGeneratedTpin());
        appUser.setGroupId(appUserDto.getGroupId());
        appUser.setLastLogin(appUserDto.getLastLogin());
        appUser.setLoginFailedCount(appUserDto.getLoginFailedCount());
        appUser.setModifiedBy(appUserDto.getModifiedBy());
        appUser.setModifiedDateTime(appUserDto.getModifiedDateTime());
        appUser.setParentId(appUserDto.getParentId());
        appUser.setPassword(appUserDto.getPassword());
        appUser.setTPin(appUserDto.getTPin());
        appUser.setSuspendDateTime(appUserDto.getSuspendDateTime());
        appUser.setUsername(appUserDto.getUsername());
        appUser.setSmsPin(appUserDto.getSmsPin());
        appUser.setEmailPin(appUserDto.getEmailPin());

        return appUser;
    }

    public static List<AppUser> convertToEntity(List<AppUserDto> appUserDtos) {
        List<AppUser> appUsers = new ArrayList<AppUser>();
        appUserDtos.forEach(appUserDto -> {
            appUsers.add(convertToEntity(appUserDto));
        });
        return appUsers;
    }
}
