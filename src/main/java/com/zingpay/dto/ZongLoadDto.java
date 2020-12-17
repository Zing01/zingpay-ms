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

    public static ZongLoadDto convertTransactionToDto(TransactionDto transactionDto) {
        ZongLoadDto zongLoadDto = new ZongLoadDto();
        zongLoadDto.setChannelNum("3158540054");
        zongLoadDto.setChannelPassword("aoEt3U+pzUk=");
        zongLoadDto.setUserNum(transactionDto.getRefTo());
        zongLoadDto.setAmount(transactionDto.getAmount().longValue());
        zongLoadDto.setRequestDate(transactionDto.getDateTime());
        zongLoadDto.setRequestId(transactionDto.getRetailerRefNumber());
        return zongLoadDto;
    }
}
