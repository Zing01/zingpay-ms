package com.zingpay.controller;

import com.zingpay.dto.UserDto;
import com.zingpay.entity.User;
import com.zingpay.service.UserService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@RestController
@RequestMapping("/user")
@Api(value="user", description="Contains methods related to user.")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PutMapping
    @PreAuthorize("hasAuthority('USER_UPDATE')")
    public Status accountSetup(@RequestBody UserDto userDto) {
        if(userDto.getPassword().equals(userDto.getConfirmPassword())) {
            User user = UserDto.convertToEntity(userDto);
            userService.update(user);
            return response(StatusMessage.ACCOUNT_SETUP_SUCCESS);
        } else {
            return response(StatusMessage.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER_READ')")
    public UserDto get() {
        User user = userService.getById(10);
        UserDto userDto = User.convertToDto(user);
        return userDto;
    }
}
