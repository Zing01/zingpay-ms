package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 9/23/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class UserAccountStatusDto {
    private int userAccountStatusId;
    private String accountStatusValue;
    private String description;
}
