package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Bilal Hassan on 09-Sep-2020
 * @project zingpay-ms
 */

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zingpay.feign")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class ZingPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZingPayApplication.class, args);
    }
}
