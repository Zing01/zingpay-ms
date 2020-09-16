package com.zingpay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@Configuration
public class EmailConfig {
    public static final String EMAIL_FROM = "perceptionit2000@gmail.com";

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername(EMAIL_FROM);
        javaMailSender.setPassword("OpsAlerts@2020");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.starttls.required", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.connectiontimeout", "5000");
        javaMailProperties.put("mail.smtp.timeout", "5000");
        javaMailProperties.put("mail.smtp.writetimeout", "5000");

        javaMailSender.setJavaMailProperties(javaMailProperties);

        return javaMailSender;
    }

}
