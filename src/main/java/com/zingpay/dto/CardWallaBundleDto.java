package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 01-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class CardWallaBundleDto {

    private String email;
    private String bundleId;
    private String msisdn;

    public CardWallaBundleDto convertTransactionToDto(TransactionDto transactionDto) {
        CardWallaBundleDto cardWallaBundleDto = new CardWallaBundleDto();
        cardWallaBundleDto.setBundleId(transactionDto.getBundleId());
        cardWallaBundleDto.setEmail(transactionDto.getEmail());
        cardWallaBundleDto.setMsisdn(transactionDto.getRefTo());

        return cardWallaBundleDto;
    }
}
