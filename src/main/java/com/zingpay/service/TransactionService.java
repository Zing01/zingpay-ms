package com.zingpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.CalculateCommissionDto;
import com.zingpay.dto.TransactionDto;
import com.zingpay.dto.TransactionPaginationDto;
import com.zingpay.dto.TransactionSummaryDto;
import com.zingpay.entity.Transaction;
import com.zingpay.repository.TransactionRepository;
import com.zingpay.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Bilal Hassan on 10/2/2020
 * @project zingpay-ms
 */

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionPaginationDto getTransactionHistory(long accountId, String fromDate, String toDate, int page, int size) {
        /*int transactionStatus = TransactionStatus.SUCCESS.getId();
        List<Integer> transactionStatuses = new ArrayList<Integer>();
        transactionStatuses.add(transactionStatus);
        int transactionType = TransactionType.DEBIT.getId();
        List<Integer> transactionTypes = new ArrayList<Integer>();
        transactionTypes.add(transactionType);
        int zingpayTransactionType = ZingpayTransactionType.TX_RECHARGE.getId();
        List<Integer> zingpayTransactionTypes = new ArrayList<Integer>();
        zingpayTransactionTypes.add(zingpayTransactionType);*/
        Pageable pageable = PageRequest.of(page, size);
        Page<Object> transactions = transactionRepository.findTransactionHistory(accountId, fromDate, toDate, pageable);
        transactions.getTotalPages();
        List<TransactionDto> transactionDto = TransactionDto.convertHistoryToDto(transactions.getContent());
        TransactionPaginationDto transactionPaginationDto = new TransactionPaginationDto(transactions.getTotalPages(), transactionDto);
        return transactionPaginationDto;
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

    public Transaction processTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionDto.convertToEntity(transactionDto);
        return transactionRepository.save(transaction);
    }

    public TransactionDto convertJSONStringToDto(String jsonString) {
        TransactionDto transactionDto = new TransactionDto();
        try {
            transactionDto = Utils.parseToObject(jsonString, TransactionDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        transactionDto.setRefFrom("zingpay");

        transactionDto.setTransactionStatus(TransactionStatus.PENDING);
        transactionDto.setTransactionType(TransactionType.DEBIT);
        if(transactionDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(transactionDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }
        if(transactionDto.getServiceProvider().equals("NADRA")) {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_BILL_PAYMENT);
        } else {
            transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
            transactionDto.setRetailerRefNumber(transactionDto.getRetailerRefNumber()+"-"+Utils.generateTenDigitsNumber());
        }

        return transactionDto;
    }

    public Transaction getById(long id) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if(transactionOptional.isPresent()) {
            return transactionOptional.get();
        }
        return null;
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void saveAll(List<Transaction> transactions) {
        transactionRepository.saveAll(transactions);
    }

    public List<CalculateCommissionDto> getFee(long serviceId, String feeType) {
        List<Object> objects = transactionRepository.findFee(serviceId, feeType);
        return CalculateCommissionDto.convertToDto(objects);
    }
}
