package com.zingpay.entity;

import com.zingpay.dto.AppUserDto;
import com.zingpay.util.AccountStatus;
import com.zingpay.util.AccountType;
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
@Table(name = "app_user")
public class AppUser {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int accountId;
    @Column(name = "parent_id")
    private int parentId;
    @Column(name = "branch_id")
    private int branchId;
    @Column(name = "group_id")
    private int groupId;
    @Column(name = "account_status_id")
    private int accountStatusId;
    @Column(name = "account_type_id")
    private int accountTypeId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "address")
    private String address;
    @Column(name = "cell_phone")
    private String cellPhone;
    @Column(name = "email")
    private String email;
    @Column(name = "cnic_number")
    private String cnicNumber;
    @Column(name = "alternate_cell_phone")
    private String alternateCellPhone;
    @Column(name = "last_login")
    private long lastLogin;
    @Column(name = "created_date_time")
    private long createDateTime;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "modified_date_time")
    private long modifiedDateTime;
    @Column(name = "modified_by")
    private int modifiedBy;
    @Column(name = "suspend_date_time")
    private long suspendDateTime;
    @Column(name = "t_pin")
    private String tPin;
    @Column(name = "login_failed_count")
    private int loginFailedCount;
    @Column(name = "is_generated_t_pin")
    private boolean isGeneratedTpin;
    @Column(name = "sms_pin")
    private String smsPin;
    @Column(name = "email_pin")
    private String emailPin;

    public static AppUserDto convertToDto(AppUser appUser) {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setAccountId(appUser.getAccountId());

        if(appUser.getAccountStatusId() == 1) {
            appUserDto.setAccountStatusId(AccountStatus.ACTIVE);
        } else if(appUser.getAccountStatusId() == 2) {
            appUserDto.setAccountStatusId(AccountStatus.PENDING);
        } else if(appUser.getAccountStatusId() == 3) {
            appUserDto.setAccountStatusId(AccountStatus.SUSPEND);
        } else if(appUser.getAccountStatusId() == 4) {
            appUserDto.setAccountStatusId(AccountStatus.INACTIVE);
        }

        if(appUser.getAccountTypeId() == 1) {
            appUserDto.setAccountTypeId(AccountType.VIRTUAL_AGENT);
        } else if(appUser.getAccountTypeId() == 2) {
            appUserDto.setAccountTypeId(AccountType.RETAILER);
        }

        appUserDto.setAddress(appUser.getAddress());
        appUserDto.setAlternateCellPhone(appUser.getAlternateCellPhone());
        appUserDto.setBranchId(appUser.getBranchId());
        appUserDto.setCellPhone(appUser.getCellPhone());
        appUserDto.setCnicNumber(appUser.getCnicNumber());
        appUserDto.setCreateDateTime(appUser.getCreateDateTime());
        appUserDto.setCreatedBy(appUser.getCreatedBy());
        appUserDto.setEmail(appUser.getEmail());
        appUserDto.setFullName(appUser.getFullName());
        appUserDto.setGeneratedTpin(appUser.isGeneratedTpin());
        appUserDto.setGroupId(appUser.getGroupId());
        appUserDto.setLastLogin(appUser.getLastLogin());
        appUserDto.setLoginFailedCount(appUser.getLoginFailedCount());
        appUserDto.setModifiedBy(appUser.getModifiedBy());
        appUserDto.setModifiedDateTime(appUser.getModifiedDateTime());
        appUserDto.setParentId(appUser.getParentId());
        appUserDto.setPassword(appUser.getPassword());
        appUserDto.setTPin(appUser.getTPin());
        appUserDto.setSuspendDateTime(appUser.getSuspendDateTime());
        appUserDto.setUsername(appUser.getUsername());
        appUserDto.setSmsPin(appUser.getSmsPin());
        appUserDto.setEmail(appUser.getEmailPin());

        return appUserDto;
    }

    public static List<AppUserDto> convertToDto(List<AppUser> appUsers) {
        List<AppUserDto> appUserDtos = new ArrayList<AppUserDto>();
        appUsers.forEach(appUser -> {
            appUserDtos.add(convertToDto(appUser));
        });
        return appUserDtos;
    }
}
