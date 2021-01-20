package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 12-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class CalculateCommissionDto {
    private double fee;
    private String feeGroupName;
    private int feeType;

    public static CalculateCommissionDto convertToDto(Object commission) {
        CalculateCommissionDto calculateCommissionDto = new CalculateCommissionDto();
        Object[] objArray = (Object[]) commission;
        calculateCommissionDto.setFee(Double.parseDouble(objArray[0].toString()));
        calculateCommissionDto.setFeeGroupName(objArray[1].toString());
        calculateCommissionDto.setFeeType(Integer.parseInt(objArray[2].toString()));
        return calculateCommissionDto;
    }

    public static List<CalculateCommissionDto> convertToDto(List<Object> commissions) {
        List<CalculateCommissionDto> calculateCommissionDtos = new ArrayList<CalculateCommissionDto>();
        commissions.forEach(commission -> {
            calculateCommissionDtos.add(convertToDto(commission));
        });
        return calculateCommissionDtos;
    }
}
