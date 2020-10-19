package com.zingpay.controller;

import com.zingpay.dto.WalletDto;
import com.zingpay.service.WalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/wallet")
@Api(value="wallet", description="Contains methods related to wallet.")
public class WalletController extends BaseController {

    @Autowired
    private WalletService walletService;

    @ApiOperation(value = "Get account balance of loggedIn user", response = Double.class)
    @GetMapping
    public WalletDto getAccountBalance() {
        WalletDto walletDto = new WalletDto();
        walletDto.setAccountBalance(walletService.getCurrentBalance(getLoggedInUserAccountId()));
        return walletDto;
    }
}
