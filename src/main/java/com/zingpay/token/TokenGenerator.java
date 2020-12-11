package com.zingpay.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.LoginResponse;
import com.zingpay.feign.AuthServiceClient;
import com.zingpay.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bilal Hassan on 08-Dec-20
 * @project zingpay-ms
 */

@Component("TokenGenerator")
public class TokenGenerator {

    @Autowired
    private AuthServiceClient authServiceClient;

    public static String token;

    public String getTokenFromAuthService() throws JsonProcessingException {
        String abc = "";
        boolean retry = true;
        long retryIn = 0;
        while(retry) {
            try {
                Thread.sleep(retryIn);
                abc = authServiceClient.login("client_credentials");
                retry = false;
                retryIn = 0;
            } catch (Exception e) {
                e.printStackTrace();
                retry = true;
                if(retryIn < 30000) {
                    retryIn += 5000;
                }
            }
        }
        LoginResponse loginResponse = Utils.parseToObject(abc, LoginResponse.class);
        return this.token = "Bearer " + loginResponse.getAccessToken();
    }
}
