package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Bilal Hassan on 10/6/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class TransactionSummaryDto {

    private double totalCredit;
    private double totalDebit;
    private double totalBuy;
    private double totalBill;
    private double totalCommission;
    private double totalServiceCharge;
    private double totalTransfer;
    private double totalRecharge;
    private double totalTransactionsCount;

    public static TransactionSummaryDto convertToDto(List<TransactionDto> transactionDtos) {
        TransactionSummaryDto transactionSummaryDto = new TransactionSummaryDto();
        transactionDtos.forEach(transactionDto -> {
            transactionSummaryDto.setTotalTransactionsCount(transactionSummaryDto.getTotalTransactionsCount() + 1);
            if(transactionDto.getTransactionStatus().getId() == 1 || transactionDto.getTransactionStatus().getId() == 3) {
                if(transactionDto.getTransactionType().getId() == 1) {
                    transactionSummaryDto.setTotalDebit(transactionSummaryDto.getTotalDebit()+transactionDto.getTransactionTotal());

                    if(transactionDto.getZingpayTransactionType().getId() == 3) {
                        transactionSummaryDto.setTotalBuy(transactionSummaryDto.getTotalBuy()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == 4) {
                        transactionSummaryDto.setTotalBill(transactionSummaryDto.getTotalBill()+transactionDto.getTransactionTotal());
                    }

                } else if(transactionDto.getTransactionType().getId() == 2) {
                    transactionSummaryDto.setTotalCredit(transactionSummaryDto.getTotalCredit()+transactionDto.getTransactionTotal());

                    if(transactionDto.getZingpayTransactionType().getId() == 1) {
                        transactionSummaryDto.setTotalRecharge(transactionSummaryDto.getTotalRecharge()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == 2) {
                        transactionSummaryDto.setTotalTransfer(transactionSummaryDto.getTotalTransfer()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == 5) {
                        transactionSummaryDto.setTotalCommission(transactionSummaryDto.getTotalCommission()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == 6) {
                        transactionSummaryDto.setTotalServiceCharge(transactionSummaryDto.getTotalServiceCharge()+transactionDto.getTransactionTotal());
                    }
                }
            }
        });
        return transactionSummaryDto;
    }
}
