package com.zingpay.service;

import com.zingpay.dto.SmsDto;
import com.zingpay.entity.AppUser;
import com.zingpay.sms.SmsSender;
import com.zingpay.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author Bilal Hassan on 22-Oct-20
 * @project zingpay-ms
 */

@Service
public class SmsService {

    @Autowired
    private SmsTemplate smsTemplate;

    @Autowired
    private SmsSender smsSender;

    @Async
    public void sendSignupSms(AppUser appUser) throws MessagingException {
        SmsDto smsDto = smsTemplate.createSignupSms(appUser);
        smsSender.sendSms(smsDto);
    }

    @Async
    public void sendSuccessActivationSms(AppUser appUser) throws MessagingException {
        SmsDto smsDto = smsTemplate.createSuccessActivationSms(appUser);
        smsSender.sendSms(smsDto);
    }

    @Async
    public void sendForgetPasswordSms(AppUser appUser) throws MessagingException {
        SmsDto smsDto = smsTemplate.createForgetPasswordSms(appUser);
        smsSender.sendSms(smsDto);
    }
}
