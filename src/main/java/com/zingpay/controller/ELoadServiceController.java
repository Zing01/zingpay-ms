package com.zingpay.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.CommissionDto;
import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.AppUser;
import com.zingpay.entity.ServiceProvider;
import com.zingpay.service.*;
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

    @Autowired
    private ServiceProviderService serviceProviderService;

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
                ServiceProvider serviceProvider = serviceProviderService.getByServiceProviderDisplayName("zong");
                transactionDto.setServiceProvider(serviceProvider.getId()+"");
                status = eLoadService.performZongLoad(transactionDto);
            } else if(transactionDto.getServiceProvider().equalsIgnoreCase("TELENOR")) {
                ServiceProvider serviceProvider = serviceProviderService.getByServiceProviderDisplayName("telenor");
                transactionDto.setServiceProvider(serviceProvider.getId()+"");
                status = eLoadService.performTelenorLoad(transactionDto);
            }
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }
        if(status.getCode()==1) {
            TransactionDto transactionDtoForCommission = null;
            try {
                transactionDtoForCommission = Utils.parseToObject(Utils.parseObjectToJson(status.getAdditionalDetail()), TransactionDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //calculateCommissionService.calculateCommission(TransactionDto.convertToEntity(transactionDtoForCommission));
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDtoForCommission.getId());
            calculateCommissionService.calculateCommission(commissionDto);
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
