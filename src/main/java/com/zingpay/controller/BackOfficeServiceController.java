package com.zingpay.controller;

import com.zingpay.service.WalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bilal Hassan on 13-Nov-20
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/backoffice/service")
@Api(value = "backoffice", description = "Controller for backoffice microservice")
public class BackOfficeServiceController extends BaseController {

    @Autowired
    private WalletService walletService;

    @ApiOperation(value = "Get current balance by account id.", response = Double.class)
    @GetMapping("/get-current-balance/{account-id}")
    public double getCurrentBalance(@PathVariable(value = "account-id") int accountId) {
        return walletService.getCurrentBalance(accountId);
    }
}
