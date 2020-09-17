package com.zingpay.controller;

import com.zingpay.dto.UserDto;
import com.zingpay.entity.User;
import com.zingpay.service.EmailService;
import com.zingpay.service.UserService;
import com.zingpay.util.Regex;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import com.zingpay.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@RestController
@RequestMapping("/unsecured")
@Api(value="unsecured", description="Contains methods which are not secured.")
public class UnsecuredController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @ApiOperation(value = "Signup call, this call takes in UserDto object as request body.", response = Status.class)
    @PostMapping("/signup")
    public Status signup(@RequestBody UserDto userDto) throws Exception {
        if(Regex.validateMobileNumber(userDto.getMobileNumber())) {
            if(Regex.validateCNIC(userDto.getCnic())) {
                if(Regex.validateEmail(userDto.getEmail())) {
                    userDto.setSmsPin(Utils.generateFourDigitPin()+"");
                    userDto.setEmailPin(Utils.generateFourDigitPin()+"");
                    userDto.setTPin(Utils.generateFourDigitPin()+"");
                    User user = UserDto.convertToEntity(userDto);
                    User savedUser = userService.save(user);
                    emailService.sendSignupEmail(savedUser);
                    return response(StatusMessage.SUCCESS, savedUser.getId());
                } else {
                    return response(StatusMessage.EMAIL_ADDRESS_NOT_VALID);
                }
            } else {
                return response(StatusMessage.CNIC_NOT_VALID);
            }
        } else {
            return response(StatusMessage.MOBILE_NUMBER_NOT_VALID);
        }
    }

    @ApiOperation(value = "Activate User through email pin by calling this api.", response = Status.class)
    @PutMapping("/activate-email")
    public Status activateWithEmailPin(@RequestBody UserDto userDto) throws Exception {
        User user = userService.getById(userDto.getId());
        if(user.getEmailPin().equals(userDto.getEmailPin())) {
            user.setActive(true);
            userService.update(user);
            emailService.sendSuccessActivationEmail(user);
            return response(StatusMessage.ACCOUNT_ACTIVATED_SUCCESS);
        } else {
            return response(StatusMessage.EMAIL_PIN_NOT_VALID);
        }
    }

    @ApiOperation(value = "Activate User through sms pin by calling this api.", response = Status.class)
    @PutMapping("/activate-sms")
    public Status activateWithSMSPin(@RequestBody UserDto userDto) throws Exception {
        User user = userService.getById(userDto.getId());
        if(user.getSmsPin().equals(userDto.getSmsPin())) {
            user.setActive(true);
            userService.update(user);
            return response(StatusMessage.ACCOUNT_ACTIVATED_SUCCESS);
        } else {
            return response(StatusMessage.EMAIL_PIN_NOT_VALID);
        }
    }
}
