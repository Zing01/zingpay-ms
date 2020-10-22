package com.zingpay.dto;

import lombok.Data;

/**
 * @author Bilal Hassan on 22-Oct-20
 * @project zingpay-ms
 */

@Data
public class SmsDto {
    private String to;
    private String text;

}
