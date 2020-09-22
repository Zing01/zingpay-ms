package com.zingpay.email;

import com.zingpay.dto.EmailDto;
import com.zingpay.entity.User;
import com.zingpay.util.Utils;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@Data
@Component
public class EmailTemplate {

    public EmailDto createSignupEmail(User user) {
        String to = user.getEmail();
        String text = "Hi " + user.getFullName() + ",\nYour activation PIN code is:" + user.getEmailPin();
        String subject = "Welcome to Zing Pay";
        //FileSystemResource file;
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(to);
        emailDto.setText(text);
        emailDto.setSubject(subject);
        //emailDto.setFile(file);
        return emailDto;
    }

    public EmailDto createSuccessActivationEmail(User user) {
        String to = user.getEmail();
        String text = "Hi " + user.getFullName() + ",\nYour account has been successfully activated, please use your T-PIN to login:" + Utils.decodePassword(user.getTPin());
        String subject = "Account Activated successfully";
        //FileSystemResource file;
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(to);
        emailDto.setText(text);
        emailDto.setSubject(subject);
        //emailDto.setFile(file);
        return emailDto;
    }

    public EmailDto createForgetPasswordEmail(User user) {
        String to = user.getEmail();
        String text = "Hi " + user.getFullName() + ",\nPlease use this code to reset your password: " + user.getEmailPin();
        String subject = "Forget Password";
        EmailDto emailDto = new EmailDto();
        emailDto.setTo(to);
        emailDto.setText(text);
        emailDto.setSubject(subject);
        return emailDto;
    }

}
