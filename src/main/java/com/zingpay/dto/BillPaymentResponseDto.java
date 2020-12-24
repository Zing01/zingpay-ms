package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 23-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class BillPaymentResponseDto {
    private String status;
    private String transactionId;
}
