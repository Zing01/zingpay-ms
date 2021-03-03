package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 01-Mar-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class CardWallaBundleDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msisdn;

    public CardWallaBundleDto convertTransactionToDto(TransactionDto transactionDto) {
        CardWallaBundleDto cardWallaBundleDto = new CardWallaBundleDto();
        cardWallaBundleDto.setProductCode(transactionDto.getBundleId());
        cardWallaBundleDto.setEmail(transactionDto.getEmail());
        cardWallaBundleDto.setMsisdn(transactionDto.getRefTo());

        return cardWallaBundleDto;
    }
}
