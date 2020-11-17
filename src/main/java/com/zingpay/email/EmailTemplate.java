package com.zingpay.email;

import com.zingpay.dto.EmailDto;
import com.zingpay.entity.AppUser;
import com.zingpay.util.Utils;
import org.springframework.stereotype.Component;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project zingpay-ms
 */

@Component
public class EmailTemplate {

    public EmailDto createSignupEmail(AppUser appUser) {
        String to = appUser.getEmail();
        String text = "Hi " + appUser.getFullName() + ",\nYour activation PIN code is:" + appUser.getPin();
        String subject = "Welcome to Zing Pay";
        //FileSystemResource file;
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(to);
        emailDto.setText(text);
        emailDto.setSubject(subject);
        //emailDto.setFile(file);
        return emailDto;
    }

    public EmailDto createSuccessActivationEmail(AppUser appUser) {
        String to = appUser.getEmail();
        String text = "Hi " + appUser.getFullName() + ",\nYour account has been successfully activated, please use your T-PIN to login:" + Utils.decodePassword(appUser.getTPin());
        String subject = "Account Activated successfully";
        //FileSystemResource file;
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(to);
        emailDto.setText(text);
        emailDto.setSubject(subject);
        //emailDto.setFile(file);
        return emailDto;
    }

    public EmailDto createForgetPasswordEmail(AppUser appUser) {
        String to = appUser.getEmail();
        String text = "Hi " + appUser.getFullName() + ",\nPlease use this code to reset your password: " + appUser.getPin();
        String subject = "Forget Password";
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(to);
        emailDto.setText(text);
        emailDto.setSubject(subject);
        return emailDto;
    }

}
