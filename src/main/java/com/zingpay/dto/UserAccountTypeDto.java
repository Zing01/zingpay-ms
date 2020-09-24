package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 9/23/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class UserAccountTypeDto {
    private int userAccountTypeId;
    private String accountTypeValue;
    private String description;
}
