package com.zingpay.service;

import com.zingpay.dto.EmailDto;
import com.zingpay.email.EmailSender;
import com.zingpay.email.EmailTemplate;
import com.zingpay.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project zingpay-ms
 */

@Service
public class EmailService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private EmailTemplate emailTemplate;

    @Async
    public void sendSignupEmail(AppUser appUser) throws MessagingException {
        EmailDto emailDto = emailTemplate.createSignupEmail(appUser);
        emailSender.sendEmail(emailDto);
    }

    @Async
    public void sendSuccessActivationEmail(AppUser appUser) throws MessagingException {
        EmailDto emailDto = emailTemplate.createSuccessActivationEmail(appUser);
        emailSender.sendEmail(emailDto);
    }

    @Async
    public void sendForgetPasswordEmail(AppUser appUser) throws MessagingException {
        EmailDto emailDto = emailTemplate.createForgetPasswordEmail(appUser);
        emailSender.sendEmail(emailDto);
    }

    @Async
    public void sendNewDeviceEmail(AppUser appUser) throws MessagingException {
        EmailDto emailDto = emailTemplate.createNewDeviceEmail(appUser);
        emailSender.sendEmail(emailDto);
    }
}
