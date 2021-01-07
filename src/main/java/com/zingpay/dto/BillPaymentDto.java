package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 23-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class BillPaymentDto {
    private String consumerNumber;
    private String shortName;
    private String amount;
    private String billingMonth;
    private String transactionId;

    public static BillPaymentDto convertTransactionToDto(TransactionDto transactionDto) {
        BillPaymentDto billPaymentDto = new BillPaymentDto();
        billPaymentDto.setAmount(transactionDto.getAmount()+"");
        billPaymentDto.setConsumerNumber(transactionDto.getRetailerRefNumber());
        billPaymentDto.setShortName(transactionDto.getRetailerRefNumber().split("-")[0]);
        //billPaymentDto.setTransactionId(transactionDto.getId()+"");
        billPaymentDto.setTransactionId(transactionDto.getRetailerRefNumber().split("-")[1]);
        billPaymentDto.setBillingMonth(transactionDto.getBillingMonth());
        return billPaymentDto;
    }
}
