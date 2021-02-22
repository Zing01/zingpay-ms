package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 06-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class TelenorBundleResponseDto {
    @JsonProperty("RequestID")
    private String requestId;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("resultmsg")
    private String resultMsg;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("errorCode")
    private String errorCode;
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorType")
    private String errorType;
}
