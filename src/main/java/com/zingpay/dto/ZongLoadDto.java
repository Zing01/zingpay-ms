package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Bilal Hassan on 08-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class ZongLoadDto {
    private String channelNum;
    private String channelPassword;
    private String userNum;
    private long amount;
    private Date requestDate;
    private String requestId;

    public ZongLoadDto convertTransactionToDto(TransactionDto transactionDto) {
        ZongLoadDto zongLoadDto = new ZongLoadDto();
        zongLoadDto.setChannelNum("");
        zongLoadDto.setChannelPassword("");
        zongLoadDto.setUserNum(transactionDto.getRefTo());
        zongLoadDto.setAmount(transactionDto.getAmount().longValue());
        zongLoadDto.setRequestDate(transactionDto.getDateTime());
        zongLoadDto.setRequestId(transactionDto.getRetailerRefNumber());
        return zongLoadDto;
    }
}
