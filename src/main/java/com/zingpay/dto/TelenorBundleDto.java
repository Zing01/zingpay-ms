package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 06-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class TelenorBundleDto {
    @JsonProperty("RetailerMsisdn")
    private String retailerMsisdn;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("RechargepartyMSISDN")
    private String rechargePartyMsisdn;
    @JsonProperty("PartnerID")
    private String partnerId;

    public TelenorBundleDto convertTransactionToDto(TransactionDto transactionDto) {
        TelenorBundleDto telenorBundleDto = new TelenorBundleDto();
        telenorBundleDto.setAmount(transactionDto.getAmount()+"");
        telenorBundleDto.setRechargePartyMsisdn(transactionDto.getRefTo());
        telenorBundleDto.setRetailerMsisdn(transactionDto.getRefFrom());
        telenorBundleDto.setPartnerId("");
        return telenorBundleDto;
    }
}
