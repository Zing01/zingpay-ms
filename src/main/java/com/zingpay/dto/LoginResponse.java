package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 08-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class LoginResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private long expiresIn;
    private String scope;
}
