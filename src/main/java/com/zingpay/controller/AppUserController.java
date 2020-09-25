package com.zingpay.controller;

import com.zingpay.dto.AppUserDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
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

    @PutMapping("/account-setup")
    //@PreAuthorize("hasAuthority('USER_UPDATE')")
    public Status accountSetup(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = appUserService.getById(appUserDto.getAccountId());
        if(appUser != null) {
            if(appUserDto.getPassword() != null) {
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
            }
        }
        return response(StatusMessage.FAILURE);
    }

    @PutMapping("/account-setting")
    public Status accountSetting(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = appUserService.getById(appUserDto.getAccountId());
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

    @GetMapping
    public List<AppUserDto> getAll() {
        return AppUser.convertToDto(appUserService.getAll());
    }
}
