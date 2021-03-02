package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("RequestID")
    private String requestId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ResultMessage")
    private String resultMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Message")
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorCode")
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorType")
    private String errorType;
}
