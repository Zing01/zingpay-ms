package com.zingpay.dto;

import com.zingpay.entity.AppUser;
import com.zingpay.util.AccountStatus;
import com.zingpay.util.AccountType;
import com.zingpay.util.DepositType;
import com.zingpay.util.HouseType;
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
    private AccountStatus accountStatus;
    private AccountType accountType;
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

    private HouseType houseType;
    private DepositType depositType;
    private String businessName;
    private String mobileLocation;
    private long cnicIssueDate;
    private String cnicFront;
    private String cnicBack;
    private String otherAttachment;
    private String transactionId;
    private long transactionDate;
    private long transactionAmount;
    private String houseNumber;
    private String oldPassword;

    public static AppUser convertToEntity(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        appUser.setAccountId(appUserDto.getAccountId());
        appUser.setAccountStatusId(appUserDto.getAccountStatus().getId());
        appUser.setAccountTypeId(appUserDto.getAccountType().getId());
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

        if(appUserDto.getHouseType() != null) {
            appUser.setHouseTypeId(appUserDto.getHouseType().getId());
        }

        if(appUserDto.getDepositType() != null) {
            appUser.setDepositTypeId(appUserDto.getDepositType().getId());
        }
        appUser.setBusinessName(appUserDto.getBusinessName());
        appUser.setMobileLocation(appUserDto.getMobileLocation());
        appUser.setCnicIssueDate(appUserDto.getCnicIssueDate());

        if(appUserDto.getCnicFront() != null) {
            appUser.setCnicFront(appUserDto.getCnicFront().getBytes());
        }

        if(appUserDto.getCnicBack() != null) {
            appUser.setCnicBack(appUserDto.getCnicBack().getBytes());
        }

        if(appUserDto.getOtherAttachment() != null) {
            appUser.setOtherAttachment(appUserDto.getOtherAttachment().getBytes());
        }

        appUser.setTransactionId(appUserDto.getTransactionId());
        appUser.setTransactionAmount(appUserDto.getTransactionAmount());
        appUser.setTransactionDate(appUserDto.getTransactionDate());
        appUser.setHouseNumber(appUserDto.getHouseNumber());

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
