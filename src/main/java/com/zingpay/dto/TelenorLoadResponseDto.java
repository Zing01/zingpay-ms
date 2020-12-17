package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 16-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class TelenorLoadResponseDto {
    @JsonProperty("RequestID")
    private String requestId;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("ResultMsg")
    private String resultMsg;
}
