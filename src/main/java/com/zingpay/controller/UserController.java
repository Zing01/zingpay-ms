package com.zingpay.controller;

import com.zingpay.dto.UserDto;
import com.zingpay.entity.User;
import com.zingpay.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        User user = UserDto.convertToEntity(userDto);
        User updatedUser = userService.update(user);
        return User.convertToDto(updatedUser);
    }
}
