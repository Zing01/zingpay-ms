package com.zingpay.controller;

import com.zingpay.dto.CommissionDto;
import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.BillPaymentService;
import com.zingpay.service.CalculateCommissionService;
import com.zingpay.service.WalletService;
import com.zingpay.util.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 22-Jan-21
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/billpayment/service")
@Api(value = "billpayment", description = "Controller for billpayment")
public class BillPaymentServiceController extends BaseController {

    @Autowired
    private BillPaymentService billPaymentService;

    @Autowired
    private CalculateCommissionService calculateCommissionService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private WalletService walletService;

    @PostMapping
    public Status performNadraBillPayment(@RequestHeader("Authorization") String token,
                                          @RequestBody TransactionDto transactionDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(transactionDto.getAccountId()+""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(transactionDto.getAccountId()+""));
        Status status = null;

        transactionDto = populateTransactionDtoFields(transactionDto);

        if(appUser.getAccountStatusId() == 1) {
            if(balance < transactionDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            status = billPaymentService.performNadraBillPayment(transactionDto);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }

        if(status.getCode()==1) {
            TransactionDto transactionDtoForCommission = (TransactionDto) status.getAdditionalDetail();
            //calculateCommissionService.calculateCommission(TransactionDto.convertToEntity(transactionDtoForCommission));
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDto.getId());
            calculateCommissionService.calculateCommission(commissionDto);
        }
        return status;
    }

    private TransactionDto populateTransactionDtoFields(TransactionDto transactionDto) {
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);

        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD); //need to discuss with ambreen
        transactionDto.setRetailerRefNumber(transactionDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        if(transactionDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(transactionDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }
        return transactionDto;
    }
}
