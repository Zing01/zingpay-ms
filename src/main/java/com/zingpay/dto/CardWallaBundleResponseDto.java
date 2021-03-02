package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 01-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class CardWallaBundleResponseDto {
    private String agentTransactionId;
    private String transactionId;
    private String resultCode;
    private String resultDescription;
}
