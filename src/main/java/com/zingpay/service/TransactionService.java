package com.zingpay.service;

import com.zingpay.dto.TransactionDto;
import com.zingpay.dto.TransactionSummaryDto;
import com.zingpay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bilal Hassan on 10/2/2020
 * @project zingpay-ms
 */

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionDto> getTransactionHistory(long accountId, String fromDate, String toDate) {
        /*int transactionStatus = TransactionStatus.SUCCESS.getId();
        List<Integer> transactionStatuses = new ArrayList<Integer>();
        transactionStatuses.add(transactionStatus);
        int transactionType = TransactionType.DEBIT.getId();
        List<Integer> transactionTypes = new ArrayList<Integer>();
        transactionTypes.add(transactionType);
        int zingpayTransactionType = ZingpayTransactionType.TX_RECHARGE.getId();
        List<Integer> zingpayTransactionTypes = new ArrayList<Integer>();
        zingpayTransactionTypes.add(zingpayTransactionType);*/

        List<Object> transactions = transactionRepository.findTransactionHistory(accountId, fromDate, toDate);
        return TransactionDto.convertHistoryToDto(transactions);
    }

    public TransactionSummaryDto getTransactionSummary(long accountId, String fromDate, String toDate) {
        /*int transactionStatus = TransactionStatus.SUCCESS.getId();
        List<Integer> transactionStatuses = new ArrayList<Integer>();
        transactionStatuses.add(transactionStatus);
        int zingpayTransactionType_TX_RECHARGE = ZingpayTransactionType.TX_RECHARGE.getId();
        int zingpayTransactionType_TX_FUND_TRANSFER = ZingpayTransactionType.TX_FUND_TRANSFER.getId();
        int zingpayTransactionType_TX_BUY = ZingpayTransactionType.TX_BUY.getId();
        int zingpayTransactionType_TX_BILL_PAYMENT = ZingpayTransactionType.TX_BILL_PAYMENT.getId();
        int zingpayTransactionType_TX_COMMISSION = ZingpayTransactionType.TX_COMMISSION.getId();
        int zingpayTransactionType_TX_SERVICE_CHARGE = ZingpayTransactionType.TX_SERVICE_CHARGE.getId();
        int zingpayTransactionType_TX_LOAD = ZingpayTransactionType.TX_LOAD.getId();
        int zingpayTransactionType_TX_CASH_IN = ZingpayTransactionType.TX_CASH_IN.getId();

        List<Integer> zingpayTransactionTypes = new ArrayList<Integer>();
        zingpayTransactionTypes.add(zingpayTransactionType_TX_RECHARGE);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_FUND_TRANSFER);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_BUY);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_BILL_PAYMENT);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_COMMISSION);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_SERVICE_CHARGE);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_LOAD);
        zingpayTransactionTypes.add(zingpayTransactionType_TX_CASH_IN);*/

        List<Object> transactions = transactionRepository.findTransactionSummary(accountId, fromDate, toDate);
        List<TransactionDto> transactionDtos = TransactionDto.convertSummaryToDto(transactions);
        return TransactionSummaryDto.convertToDto(transactionDtos);
    }
}
