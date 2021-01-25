package com.zingpay.sms;

import com.zingpay.dto.SmsDto;
import com.zingpay.entity.AppUser;
import com.zingpay.util.Utils;
import org.springframework.stereotype.Component;

/**
 * @author Bilal Hassan on 22-Oct-20
 * @project zingpay-ms
 */

@Component
public class SmsTemplate {

    public SmsDto createSignupSms(AppUser appUser) {
        String to = appUser.getCellPhone();
        String text = "<#>Hi " + appUser.getFullName() + ",\nYour activation PIN code is:" + appUser.getPin();
        SmsDto smsDto = new SmsDto();
        smsDto.setTo(to);
        smsDto.setText(text);
        return smsDto;
    }

    public SmsDto createSuccessActivationSms(AppUser appUser) {
        String to = appUser.getCellPhone();
        String text = "<#>Hi " + appUser.getFullName() + ",\nYour account has been successfully activated, please use your T-PIN to login:" + Utils.decodePassword(appUser.getTPin());
        SmsDto smsDto = new SmsDto();
        smsDto.setTo(to);
        smsDto.setText(text);
        return smsDto;
    }

    public SmsDto createForgetPasswordSms(AppUser appUser) {
        String to = appUser.getCellPhone();
        String text = "<#>Hi " + appUser.getFullName() + ",\nPlease use this code to reset your password: " + appUser.getPin();
        SmsDto smsDto = new SmsDto();
        smsDto.setTo(to);
        smsDto.setText(text);
        return smsDto;
    }

    public SmsDto createNewDeviceSms(AppUser appUser) {
        String to = appUser.getCellPhone();
        String text = "<#>Hi " + appUser.getFullName() + ",\nPlease use this code for verification of new device: " + appUser.getPin();
        SmsDto smsDto = new SmsDto();
        smsDto.setTo(to);
        smsDto.setText(text);
        return smsDto;
    }
}
