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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

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

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @ApiOperation(value = "Signup call, this call takes in UserDto object as request body.", response = Status.class)
    @PostMapping("/signup")
    public Status signup(@RequestBody AppUserDto appUserDto) {
        Status status = AppUserValidator.validateOnRegister(appUserDto);
        if(status.getCode() == 1) {
            appUserDto.setPin(Utils.generateFourDigitPin()+"");
            appUserDto.setTPin(Utils.encodePassword(Utils.generateFourDigitPin()+""));

            appUserDto.setGroupId(1);
            appUserDto.setAccountType(AccountType.RETAILER);
            appUserDto.setAccountStatus(AccountStatus.PENDING);
            appUserDto.setUsername(appUserDto.getCellPhone());

            AppUser appUser = AppUserDto.convertToEntity(appUserDto);
            try {
                AppUser savedAppUser = appUserService.save(appUser);
                emailService.sendSignupEmail(savedAppUser);
                smsService.sendSignupSms(savedAppUser);
                return response(StatusMessage.ACCOUNT_CREATION_SUCCESS, savedAppUser.getAccountId());
            } catch (DataIntegrityViolationException e) {
                AppUser appUser1 = appUserService.getByCellPhone(appUserDto.getCellPhone());
                if(appUser1 == null) {
                    if(e.getLocalizedMessage().contains("app_user_email_uindex")) {
                        return response(StatusMessage.EMAIL_ALREADY_EXISTS);
                    }
                    if(e.getLocalizedMessage().contains("app_user_cnic_number_uindex")) {
                        return response(StatusMessage.CNIC_ALREADY_EXISTS);
                    }
                } else /*if(e.getLocalizedMessage().contains("app_user_cell_phone_uindex"))*/ {
                    appUser1.setCnicNumber(appUserDto.getCnicNumber());
                    appUser1.setEmail(appUserDto.getEmail());
                    appUser1.setFullName(appUserDto.getFullName());
                    try {
                        AppUser savedAppUser = appUserService.update(appUser1);
                        try {
                            emailService.sendSignupEmail(savedAppUser);
                            smsService.sendSignupSms(savedAppUser);
                        } catch (MessagingException ex) {
                            ex.printStackTrace();
                        }
                    } catch (DataIntegrityViolationException ex) {
                        if(ex.getLocalizedMessage().contains("app_user_email_uindex")) {
                            return response(StatusMessage.EMAIL_ALREADY_EXISTS);
                        }
                        if(ex.getLocalizedMessage().contains("app_user_cnic_number_uindex")) {
                            return response(StatusMessage.CNIC_ALREADY_EXISTS);
                        }
                    }
                    return response(StatusMessage.ACCOUNT_CREATION_SUCCESS, appUser1.getAccountId());
                }
                return response(StatusMessage.FAILURE);
            } catch (Exception e) {
                e.printStackTrace();
                return response(StatusMessage.FAILURE);
            }
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
            if(appUser.getPassword() == null || appUser.getPassword().equals("")) {
                return response(StatusMessage.USE_EXISTING_TPIN);
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
            if(appUser.getPassword() == null || appUser.getPassword().equals("")) {
                return response(StatusMessage.USE_EXISTING_TPIN);
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
                if(passwordEncoder.matches(appUserDto.getPassword(), appUser.getPassword())) {
                    return response(StatusMessage.OLD_PASSWORD_CANNOT_BE_USED);
                }
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
