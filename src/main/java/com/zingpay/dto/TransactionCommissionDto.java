package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Bilal Hassan on 13-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class TransactionCommissionDto {
    private TransactionDto transactionDto;
    private List<CalculateCommissionDto> calculateCommissionDtos;
    private List<AppUserDtoForCommission> appUserDtoForCommissions;
}