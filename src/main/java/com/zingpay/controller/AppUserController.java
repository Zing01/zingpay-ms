package com.zingpay.controller;

import com.zingpay.dto.AppUserDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import com.zingpay.validator.AppUserValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@RestController
@RequestMapping("/user")
@Api(value="user", description="Contains methods related to user.")
public class AppUserController extends BaseController {

    @Autowired
    private AppUserService appUserService;

    @ApiOperation(value = "Account Setup call takes in UserDto object as request body.", response = Status.class)
    @PutMapping("/account-setup")
    public Status accountSetup(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = appUserService.getByEmail(getLoggedInUserEmail());
        if(appUser != null) {
            Status status = AppUserValidator.validateOnAccountSetup(appUserDto);
            if(status.getCode() == 1) {
                appUser.setBusinessName(appUserDto.getBusinessName());
                appUser.setMobileLocation(appUserDto.getMobileLocation());
                appUser.setAccountTypeId(appUserDto.getAccountType().getId());
                if(appUserDto.getDepositType() != null) {
                    appUser.setDepositTypeId(appUserDto.getDepositType().getId());
                }
                appUser.setTransactionId(appUserDto.getTransactionId());
                appUser.setTransactionDate(appUserDto.getTransactionDate());
                appUser.setTransactionAmount(appUserDto.getTransactionAmount());
                appUser.setCnicIssueDate(appUserDto.getCnicIssueDate());
                appUser.setCnicFront(appUserDto.getCnicFront().getBytes());
                appUser.setCnicBack(appUserDto.getCnicBack().getBytes());
                if(appUserDto.getProfilePicture() != null) {
                    appUser.setProfilePicture(appUserDto.getProfilePicture().getBytes());
                }
                if(appUserDto.getServiceType() != null) {
                    appUser.setServiceTypeId(appUserDto.getServiceType().getId());
                }

                if(appUserDto.getOtherAttachment() != null) {
                    appUser.setOtherAttachment(appUserDto.getOtherAttachment().getBytes());
                } else {

                }
                appUser.setHouseNumber(appUserDto.getHouseNumber());
                if(appUserDto.getHouseType() != null) {
                    appUser.setHouseTypeId(appUserDto.getHouseType().getId());
                }

                AppUser savedAppUser = appUserService.update(appUser);
                return new Status(StatusMessage.ACCOUNT_SETUP_SUCCESS, savedAppUser.getAccountId());
            } else {
                return status;
            }
            /*if(appUserDto.getPassword() != null) {
                if (appUserDto.getPassword().equals(appUserDto.getConfirmPassword())) {
                    appUserDto.setTPin(appUser.getTPin());
                    appUserDto.setEmailPin(appUser.getEmailPin());
                    appUserDto.setSmsPin(appUser.getSmsPin());
                    appUser = AppUserDto.convertToEntity(appUserDto);
                    appUserService.update(appUser);
                    return response(StatusMessage.ACCOUNT_SETUP_SUCCESS);
                } else {
                    return response(StatusMessage.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED);
                }
            }*/

        }
        return response(StatusMessage.FAILURE);
    }

    @ApiOperation(value = "Account Setting call takes in UserDto object as request body.", response = Status.class)
    @PutMapping("/account-setting")
    public Status accountSetting(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = appUserService.getByEmail(getLoggedInUserEmail());
        if(appUser != null) {
            if(appUserDto.getPassword() != null) {
                if (appUserDto.getPassword().equals(appUserDto.getConfirmPassword())) {
                    if (!appUserDto.getUsername().equals(appUser.getUsername())) {
                        return response(StatusMessage.USERNAME_NOT_CHANGE);
                    }
                    appUserDto.setTPin(appUser.getTPin());
                    appUserDto.setEmailPin(appUser.getEmailPin());
                    appUserDto.setSmsPin(appUser.getSmsPin());
                    appUser = AppUserDto.convertToEntity(appUserDto);
                    appUserService.update(appUser);
                    return response(StatusMessage.ACCOUNT_SETTING_SUCCESS);
                } else {
                    return response(StatusMessage.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED);
                }
            }
        }
        return response(StatusMessage.FAILURE);
    }

    @ApiOperation(value = "Get all app users", response = List.class)
    @GetMapping
    public List<AppUserDto> getAll() {
        return AppUser.convertToDto(appUserService.getAll());
    }

    @ApiOperation(value = "Change Password, takes in password, confirm password, old password and accountId as request body", response = Status.class)
    @PutMapping("/change-password")
    public Status changePassword(@RequestBody AppUserDto appUserDto) {
        try {
            return appUserService.changePassword(appUserDto);
        } catch (Exception e) {
            return response(StatusMessage.PASSWORD_RESET_FAILED);
        }
    }
}
