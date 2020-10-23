package com.zingpay.controller;

import com.zingpay.dto.AppUserDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.EmailService;
import com.zingpay.service.SmsService;
import com.zingpay.util.*;
import com.zingpay.validator.AppUserValidator;
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
    private AppUserService appUserService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;


    @ApiOperation(value = "Signup call, this call takes in UserDto object as request body.", response = Status.class)
    @PostMapping("/signup")
    public Status signup(@RequestBody AppUserDto appUserDto) throws Exception {
        Status status = AppUserValidator.validateOnRegister(appUserDto);
        if(status.getCode() == 1) {
            appUserDto.setPin(Utils.generateFourDigitPin()+"");
            appUserDto.setTPin(Utils.encodePassword(Utils.generateFourDigitPin()+""));

            appUserDto.setGroupId(1);
            appUserDto.setAccountType(AccountType.RETAILER);
            appUserDto.setAccountStatus(AccountStatus.PENDING);
            appUserDto.setUsername(appUserDto.getCellPhone());

            AppUser appUser = AppUserDto.convertToEntity(appUserDto);
            AppUser savedAppUser = appUserService.save(appUser);
            emailService.sendSignupEmail(savedAppUser);
            smsService.sendSignupSms(savedAppUser);
            return response(StatusMessage.ACCOUNT_CREATION_SUCCESS, savedAppUser.getAccountId());
        } else {
            return status;
        }
    }

    @ApiOperation(value = "Activate User through pin by calling this api. Takes in accountId and pin as request body", response = Status.class)
    @PutMapping("/activate")
    public Status activate(@RequestBody AppUserDto appUserDto) throws Exception {
        AppUser appUser = appUserService.getById(appUserDto.getAccountId());
        if(appUser.getPin().equals(appUserDto.getPin())) {
            appUser.setAccountStatusId(AccountStatus.ACTIVE.getId());
            appUserService.save(appUser);
            emailService.sendSuccessActivationEmail(appUser);
            smsService.sendSuccessActivationSms(appUser);
            return response(StatusMessage.ACCOUNT_ACTIVATED_SUCCESS);
        } else {
            return response(StatusMessage.PIN_NOT_VALID);
        }
    }

    @ApiOperation(value = "Resend Email, takes in email as request param", response = Status.class)
    @GetMapping("/resend-email")
    public Status resendEmail(@RequestParam(name = "email", required = true) String email,
                              @RequestParam(name = "isForgetPassword", required = true) boolean isForgetPassword) {
        try {
            AppUser appUser = appUserService.getByEmail(email);
            if(appUser == null) {
                return response(StatusMessage.EMAIL_NOT_FOUND);
            }
            appUser.setPin(Utils.generateFourDigitPin()+"");
            appUserService.save(appUser);
            if(isForgetPassword) {
                emailService.sendForgetPasswordEmail(appUser);
            } else {
                emailService.sendSignupEmail(appUser);
            }
            return response(StatusMessage.EMAIL_SENT_SUCCESSFULLY);
        } catch (Exception e) {
            return response(StatusMessage.EMAIL_SENT_FAILED);
        }
    }

    @ApiOperation(value = "Resend Sms, takes in cell phone as request param", response = Status.class)
    @GetMapping("/resend-sms")
    public Status resendSms(@RequestParam(name = "cellPhone", required = true) String cellPhone,
                              @RequestParam(name = "isForgetPassword", required = true) boolean isForgetPassword) {
        try {
            AppUser appUser = appUserService.getByCellPhone(cellPhone);
            if(appUser == null) {
                return response(StatusMessage.CELL_PHONE_NOT_FOUND);
            }
            appUser.setPin(Utils.generateFourDigitPin()+"");
            appUserService.save(appUser);
            if(isForgetPassword) {
                smsService.sendForgetPasswordSms(appUser);
            } else {
                smsService.sendSignupSms(appUser);
            }
            return response(StatusMessage.SMS_SENT_SUCCESSFULLY);
        } catch (Exception e) {
            return response(StatusMessage.SMS_SENT_FAILED);
        }
    }

    @ApiOperation(value = "Forget Password, takes in email and cnic as request param", response = Status.class)
    @GetMapping("/forget-password-email")
    public Status forgetPasswordEmail(@RequestParam(name = "email", required = true) String email, @RequestParam(name = "cnic", required = true) String cnic) {
        try {
            AppUser appUser = appUserService.getByEmail(email);
            if(appUser == null) {
                return response(StatusMessage.EMAIL_NOT_FOUND);
            }
            if(!appUser.getCnicNumber().equals(cnic)) {
                return response(StatusMessage.CNIC_NOT_FOUND);
            }
            appUser.setPin(Utils.generateFourDigitPin()+"");
            appUserService.save(appUser);
            emailService.sendForgetPasswordEmail(appUser);
            return response(StatusMessage.EMAIL_SENT_SUCCESSFULLY, appUser.getAccountId());
        } catch (Exception e) {
            return response(StatusMessage.EMAIL_SENT_FAILED);
        }
    }

    @ApiOperation(value = "Forget Password, takes in cell phone and cnic as request param", response = Status.class)
    @GetMapping("/forget-password-cell-phone")
    public Status forgetPasswordCellPhone(@RequestParam(name = "cellPhone", required = true) String cellPhone, @RequestParam(name = "cnic", required = true) String cnic) {
        try {
            AppUser appUser = appUserService.getByCellPhone(cellPhone);
            if(appUser == null) {
                return response(StatusMessage.CELL_PHONE_NOT_FOUND);
            }
            if(!appUser.getCnicNumber().equals(cnic)) {
                return response(StatusMessage.CNIC_NOT_FOUND);
            }
            appUser.setPin(Utils.generateFourDigitPin()+"");
            appUserService.save(appUser);
            smsService.sendForgetPasswordSms(appUser);
            return response(StatusMessage.SMS_SENT_SUCCESSFULLY, appUser.getAccountId());
        } catch (Exception e) {
            return response(StatusMessage.SMS_SENT_FAILED);
        }
    }

    @ApiOperation(value = "Validate Pin, takes in accountId and pin as request body", response = Status.class)
    @PutMapping("/validate")
    public Status validate(@RequestBody AppUserDto appUserDto) {
        try {
            AppUser appUser = appUserService.getById(appUserDto.getAccountId());
            if(appUser.getPin().equals(appUserDto.getPin())) {
                return response(StatusMessage.PIN_VALIDATION_SUCCESS);
            } else {
                return response(StatusMessage.PIN_NOT_VALID);
            }
        } catch (Exception e) {
            return response(StatusMessage.PIN_NOT_VALID);
        }
    }

    @ApiOperation(value = "Reset Password, takes in password, confirm password and accountId as request body", response = Status.class)
    @PutMapping("/reset-password")
    public Status resetPassword(@RequestBody AppUserDto appUserDto) {
        try {
            if(appUserDto.getPassword().equals(appUserDto.getConfirmPassword())) {
                AppUser appUser = appUserService.getById(appUserDto.getAccountId());
                appUser.setPassword(appUserDto.getPassword());
                appUserService.save(appUser);
                return response(StatusMessage.PASSWORD_RESET_SUCCESS);
            } else {
                return response(StatusMessage.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED);
            }
        } catch (Exception e) {
            return response(StatusMessage.PASSWORD_RESET_FAILED);
        }
    }
}
