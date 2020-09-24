package com.zingpay.controller;

import com.zingpay.dto.AppUserDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping
    //@PreAuthorize("hasAuthority('USER_UPDATE')")
    public Status accountSetup(@RequestBody AppUserDto appUserDto) {
        if(appUserDto.getPassword().equals(appUserDto.getConfirmPassword())) {
            AppUser appUser = AppUserDto.convertToEntity(appUserDto);
            appUserService.update(appUser);
            return response(StatusMessage.ACCOUNT_SETUP_SUCCESS);
        } else {
            return response(StatusMessage.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED);
        }
    }
}
