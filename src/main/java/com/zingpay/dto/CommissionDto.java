package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 04-Feb-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class CommissionDto {
    private int accountId;
    private long transactionId;
    private long serviceId;
}
