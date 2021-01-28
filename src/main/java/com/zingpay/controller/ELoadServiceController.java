package com.zingpay.controller;

import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.CalculateCommissionService;
import com.zingpay.service.ELoadService;
import com.zingpay.service.WalletService;
import com.zingpay.util.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 23-Oct-20
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/eload/service")
@Api(value = "eload", description = "Controller for eload microservice")
public class ELoadServiceController extends BaseController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private ELoadService eLoadService;

    @Autowired
    private CalculateCommissionService calculateCommissionService;

    @PostMapping
    public Status validateAndPerformLoad(@RequestHeader("Authorization") String token,
                                      @RequestBody TransactionDto transactionDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(transactionDto.getAccountId()+""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(transactionDto.getAccountId()+""));
        Status status = null;

        transactionDto = populateTransactionDtoFields(transactionDto);

        if(appUser.getAccountStatusId() == 1) {
            if(balance < transactionDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            if(transactionDto.getServiceProvider().equalsIgnoreCase("ZONG")) {
                status = eLoadService.performZongLoad(transactionDto);
            } else if(transactionDto.getServiceProvider().equalsIgnoreCase("TELENOR")) {
                status = eLoadService.performTelenorLoad(transactionDto);
            }
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }
        if(status.getCode()==1) {
            TransactionDto transactionDtoForCommission = (TransactionDto) status.getAdditionalDetail();
            calculateCommissionService.calculateCommission(TransactionDto.convertToEntity(transactionDtoForCommission));
        }
        return status;
    }

    private TransactionDto populateTransactionDtoFields(TransactionDto transactionDto) {
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);

        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        transactionDto.setRetailerRefNumber(transactionDto.getRetailerRefNumber()+"-"+Utils.generateTenDigitsNumber());

        if(transactionDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(transactionDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }
        return transactionDto;
    }
}
