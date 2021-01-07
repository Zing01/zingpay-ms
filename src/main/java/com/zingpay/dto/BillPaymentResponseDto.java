package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String transactionId;
}
