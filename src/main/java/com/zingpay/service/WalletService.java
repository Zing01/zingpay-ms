package com.zingpay.service;

import com.zingpay.dto.TransactionResponseDto;
import com.zingpay.entity.AppUser;
import com.zingpay.repository.AppUserRepository;
import com.zingpay.repository.TransactionRepository;
import com.zingpay.util.TransactionStatus;
import com.zingpay.util.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

@Service
@Transactional
public class WalletService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public double getCurrentBalanceByAccountId(String email) {
        AppUser appUser = appUserRepository.findByEmail(email);
        List<Object> objects = transactionRepository.findAllByCustomQuery(appUser.getAccountId());
        List<TransactionResponseDto> transactionResponseDtos = new ArrayList<TransactionResponseDto>();
        for (Object object : objects) {
            TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
            Object[] objArray = (Object[]) object;
            transactionResponseDto.setAmount(Double.parseDouble(objArray[0].toString()));
            transactionResponseDto.setTransactionTypeId(Long.parseLong(objArray[1].toString()));
            transactionResponseDto.setTransactionStatusId(Long.parseLong(objArray[2].toString()));
            transactionResponseDtos.add(transactionResponseDto);
        }

        return calculateBalance(transactionResponseDtos);
    }


    private double calculateBalance(List<TransactionResponseDto> transactionResponseDtos) {
        double totalDebit = 0.00;
        double totalCredit = 0.00;

        for (TransactionResponseDto transactionResponseDto : transactionResponseDtos) {
            //int transactionTypeId = transactionResponseDto.getTransactionType().getId();
            //int transactionStatusId = transactionResponseDto.getTransactionStatus().getId();

            long transactionTypeId = transactionResponseDto.getTransactionTypeId();
            long transactionStatusId = transactionResponseDto.getTransactionStatusId();
            double amount = transactionResponseDto.getAmount();
            if (TransactionStatus.FAILED.getId() == transactionStatusId) {
                //continue;
            }
            if (TransactionType.CREDIT.getId() == transactionTypeId) {
                // pending CREDIT transactions should not reflect
                // in balance but pending DEBIT transactions should.
                if (TransactionStatus.PENDING.getId() != transactionStatusId) {

                    totalCredit = totalCredit+amount;
                }
            } else if (TransactionType.DEBIT.getId() == transactionTypeId) {
                totalDebit = totalDebit+amount;
            }
        }
        return totalCredit-totalDebit;
    }
}
