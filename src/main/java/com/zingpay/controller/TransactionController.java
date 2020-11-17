package com.zingpay.controller;

import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.TransactionService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bilal Hassan on 10/2/2020
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/transaction")
@Api(value="transaction", description="Contains methods related to transactions.")
public class TransactionController extends BaseController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AppUserService appUserService;

    @ApiOperation(value = "Get transaction history, takes in from date, to date, page, and size as request param", response = Status.class)
    @GetMapping("/transaction-history")
    public Status getTransactionHistory(@RequestParam("fromDate") String fromDate,
                                                          @RequestParam("toDate") String toDate,
                                                          @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                          @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        int loggedInUserAccountId = getLoggedInUserAccountId();
        AppUser appUser = appUserService.getById(loggedInUserAccountId);
        return response(new Status(StatusMessage.SUCCESS, transactionService.getTransactionHistory(appUser.getAccountId(), fromDate, toDate, page, size)));
    }

    @ApiOperation(value = "Get transaction summary, takes in from date and to date as request param", response = Status.class)
    @GetMapping("/transaction-summary")
    public Status getTransactionSummary(@RequestParam("fromDate") String fromDate,
                                                             @RequestParam("toDate") String toDate) {
        int loggedInUserAccountId = getLoggedInUserAccountId();
        AppUser appUser = appUserService.getById(loggedInUserAccountId);
        return response(new Status(StatusMessage.SUCCESS, transactionService.getTransactionSummary(appUser.getAccountId(), fromDate, toDate)));
    }
}
