package com.zingpay.service;

import com.zingpay.dto.EmailDto;
import com.zingpay.email.EmailSender;
import com.zingpay.email.EmailTemplate;
import com.zingpay.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@Service
public class EmailService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private EmailTemplate emailTemplate;

    @Async
    public void sendSignupEmail(User user) throws MessagingException {
        EmailDto emailDto = emailTemplate.createSignupEmail(user);
        emailSender.sendEmail(emailDto);
    }

    @Async
    public void sendSuccessActivationEmail(User user) throws MessagingException {
        EmailDto emailDto = emailTemplate.createSuccessActivationEmail(user);
        emailSender.sendEmail(emailDto);
    }
}
