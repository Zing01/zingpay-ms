package com.zingpay.dto;

import com.zingpay.util.TransactionStatus;
import com.zingpay.util.TransactionType;
import com.zingpay.util.ZingpayTransactionType;
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
    private long totalTransactionsCount;

    public static TransactionSummaryDto convertToDto(List<TransactionDto> transactionDtos) {
        TransactionSummaryDto transactionSummaryDto = new TransactionSummaryDto();
        transactionDtos.forEach(transactionDto -> {
            transactionSummaryDto.setTotalTransactionsCount(transactionSummaryDto.getTotalTransactionsCount() + 1);
            if(transactionDto.getTransactionStatus().getId() == TransactionStatus.SUCCESS.getId() || transactionDto.getTransactionStatus().getId() == TransactionStatus.PENDING.getId()) {
                if(transactionDto.getTransactionType().getId() == TransactionType.DEBIT.getId()) {
                    transactionSummaryDto.setTotalDebit(transactionSummaryDto.getTotalDebit()+transactionDto.getTransactionTotal());

                    if(transactionDto.getZingpayTransactionType().getId() == ZingpayTransactionType.TX_BUY.getId()) {
                        transactionSummaryDto.setTotalBuy(transactionSummaryDto.getTotalBuy()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == ZingpayTransactionType.TX_BILL_PAYMENT.getId()) {
                        transactionSummaryDto.setTotalBill(transactionSummaryDto.getTotalBill()+transactionDto.getTransactionTotal());
                    }

                } else if(transactionDto.getTransactionType().getId() == TransactionType.CREDIT.getId()) {
                    transactionSummaryDto.setTotalCredit(transactionSummaryDto.getTotalCredit()+transactionDto.getTransactionTotal());

                    if(transactionDto.getZingpayTransactionType().getId() == ZingpayTransactionType.TX_RECHARGE.getId()) {
                        transactionSummaryDto.setTotalRecharge(transactionSummaryDto.getTotalRecharge()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == ZingpayTransactionType.TX_FUND_TRANSFER.getId()) {
                        transactionSummaryDto.setTotalTransfer(transactionSummaryDto.getTotalTransfer()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == ZingpayTransactionType.TX_COMMISSION.getId()) {
                        transactionSummaryDto.setTotalCommission(transactionSummaryDto.getTotalCommission()+transactionDto.getTransactionTotal());
                    } else if(transactionDto.getZingpayTransactionType().getId() == ZingpayTransactionType.TX_SERVICE_CHARGE.getId()) {
                        transactionSummaryDto.setTotalServiceCharge(transactionSummaryDto.getTotalServiceCharge()+transactionDto.getTransactionTotal());
                    }
                }
            }
        });
        return transactionSummaryDto;
    }
}
