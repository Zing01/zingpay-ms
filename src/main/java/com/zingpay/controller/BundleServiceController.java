package com.zingpay.controller;

import com.zingpay.dto.BundleDetailsDto;
import com.zingpay.dto.BundleDto;
import com.zingpay.dto.CommissionDto;
import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.AppUser;
import com.zingpay.entity.Bundle;
import com.zingpay.service.AppUserService;
import com.zingpay.service.BundleService;
import com.zingpay.service.CalculateCommissionService;
import com.zingpay.service.WalletService;
import com.zingpay.util.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/bundle/service")
@Api(value = "bundle", description = "Controller for bundles")
public class BundleServiceController extends BaseController {

    @Autowired
    private BundleService bundleService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private CalculateCommissionService calculateCommissionService;

    @GetMapping("/{network}")
    public Status getBundles(@RequestHeader("Authorization") String token,
                             @PathVariable("network") String network) {
        List<Bundle> bundles = bundleService.getBundlesByNetwork(network);
        List<BundleDto> bundleDtos = Bundle.convertToDto(bundles);
        BundleDetailsDto bundleDetailsDto = new BundleDetailsDto();
        bundleDetailsDto.setBundleDto(bundleDtos);
        bundleDetailsDto.setCategories(new String[]{"All", "Popular", "Data", "Monthly Hybrid", "Weekly Hybrid", "SMS", "IR Bundle", "Call"});
        return new Status(StatusMessage.SUCCESS, bundleDetailsDto);
    }

    @GetMapping("/{network}/{type}")
    public Status getBundlesForCardWala(@RequestHeader("Authorization") String token,
                                        @PathVariable("network") String network,
                                        @PathVariable("type") String type) {
        List<Bundle> bundles = bundleService.getBundlesByNetworkAndProductId(network, type);
        List<BundleDto> bundleDtos = Bundle.convertToDto(bundles);
        BundleDetailsDto bundleDetailsDto = new BundleDetailsDto();
        bundleDetailsDto.setBundleDto(bundleDtos);
        bundleDetailsDto.setCategories(new String[]{"All", "Popular", "Data", "Monthly Hybrid", "Weekly Hybrid", "SMS", "IR Bundle", "Call"});
        return new Status(StatusMessage.SUCCESS, bundleDetailsDto);
    }

    @PostMapping
    public Status validateUserAndSubscribeBundle(@RequestHeader("Authorization") String token,
                                                 @RequestBody TransactionDto transactionDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(transactionDto.getAccountId() + ""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(transactionDto.getAccountId() + ""));
        Status status = null;

        transactionDto = populateTransactionDtoFields(transactionDto);

        if (appUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
            if (balance < transactionDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            if (transactionDto.getServiceProvider().equalsIgnoreCase("ZONG")) {
                status = bundleService.subscribeZongBundle(transactionDto);
            } else if (transactionDto.getServiceProvider().equalsIgnoreCase("TELENOR")) {
                status = bundleService.subscribeTelenorBundle(transactionDto);
            } else if (transactionDto.getServiceProvider().equalsIgnoreCase("CARDWALLA")) {
                status = bundleService.subscribeCardwallaBundle(transactionDto);
            }
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }
        if (status.getCode() == 1) {
            //calculateCommissionService.calculateCommission(TransactionDto.convertToEntity(transactionDtoForCommission));
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId() + ""));
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
        transactionDto.setRetailerRefNumber(transactionDto.getRetailerRefNumber() + "-" + Utils.generateTenDigitsNumber());

        if (transactionDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if (transactionDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }
        return transactionDto;
    }
}
