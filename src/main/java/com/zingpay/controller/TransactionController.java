package com.zingpay.controller;

import com.zingpay.dto.TransactionDto;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/transaction-history")
    public List<TransactionDto> getTransactionHistory(@RequestParam("fromDate") String fromDate,
                                                   @RequestParam("toDate") String toDate) {
        String loggedInUserEmail = getLoggedInUserEmail();
        AppUser appUser = appUserService.getByEmail(loggedInUserEmail);
        return transactionService.getTransactionHistory(appUser.getAccountId(), fromDate, toDate);
    }

    @GetMapping("/transaction-summary")
    public List<TransactionDto> getTransactionSummary(@RequestParam("fromDate") String fromDate,
                                                   @RequestParam("toDate") String toDate) {
        String loggedInUserEmail = getLoggedInUserEmail();
        AppUser appUser = appUserService.getByEmail(loggedInUserEmail);
        return transactionService.getTransactionSummary(appUser.getAccountId(), fromDate, toDate);
    }
}
