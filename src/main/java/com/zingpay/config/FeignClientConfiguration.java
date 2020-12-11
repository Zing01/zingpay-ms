package com.zingpay.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bilal Hassan on 08-Dec-20
 * @project zingpay-ms
 */

@Configuration
public class FeignClientConfiguration {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("client", "secret");
    }
}
