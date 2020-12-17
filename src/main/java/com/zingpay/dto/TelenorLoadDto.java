package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 16-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class TelenorLoadDto {
    @JsonProperty("RetailerMsisdn")
    private String retailerMsisdn;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("CustomerMsisdn")
    private String customerMsisdn;
    @JsonProperty("vendorName1")
    private String vendorName1;
    @JsonProperty("vendorName2")
    private String vendorName2;
    @JsonProperty("requestID")
    private String requestId;

    public static TelenorLoadDto convertTransactionToDto(TransactionDto transactionDto) {
        TelenorLoadDto telenorLoadDto = new TelenorLoadDto();
        telenorLoadDto.setRetailerMsisdn(transactionDto.getRefFrom());
        telenorLoadDto.setCustomerMsisdn(transactionDto.getRefTo());
        telenorLoadDto.setAmount(transactionDto.getAmount()+"");
        telenorLoadDto.setVendorName1("IMTOPUP:CBA");
        telenorLoadDto.setVendorName2("IMTOPUP:CBA");
        telenorLoadDto.setRequestId(transactionDto.getRetailerRefNumber());
        return telenorLoadDto;
    }
}
