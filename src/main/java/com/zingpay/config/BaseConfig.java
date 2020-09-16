package com.zingpay.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@Configuration
public class BaseConfig {
    @Bean
    public ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        objectMapper.registerModule(hibernate5Module);

        return objectMapper;
    }

    @Autowired
    private EntityManager entityManager;
}
