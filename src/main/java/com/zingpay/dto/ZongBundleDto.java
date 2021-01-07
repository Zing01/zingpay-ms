package com.zingpay.dto;

import com.zingpay.util.Utils;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 06-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class ZongBundleDto {

    private String bundleId;
    private String userNum;
    private String requestId;

    public ZongBundleDto convertTransactionToDto(TransactionDto transactionDto) {
        ZongBundleDto zongBundleDto = new ZongBundleDto();
        zongBundleDto.setUserNum(transactionDto.getRefTo());
        zongBundleDto.setBundleId(transactionDto.getBundleId());
        zongBundleDto.setRequestId(transactionDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        return zongBundleDto;
    }
}
