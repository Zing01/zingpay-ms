package com.zingpay.controller;

import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.TransactionService;
import com.zingpay.service.WalletService;
import com.zingpay.util.AccountStatus;
import com.zingpay.util.ChannelType;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private WalletService walletService;

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

    @ApiOperation(value = "Takes in amount and cell phone of recipient user to transfer balance", response = Status.class)
    @PutMapping("/balance-transfer")
    public Status balanceTransfer(@RequestParam("cell-phone") String cellPhone,
                                  @RequestParam("amount") double amount,
                                  @RequestParam("channel-type") ChannelType channelType) {
        try {
            AppUser fromAccountAppUser = appUserService.getById(getLoggedInUserAccountId());
            double balance = walletService.getCurrentBalance(fromAccountAppUser.getAccountId());
            if(fromAccountAppUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
                if(balance < amount) {
                    return new Status(StatusMessage.INSUFFICIENT_BALANCE);
                }
            } else {
                return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
            }

            AppUser toAccountAppUser = appUserService.getByCellPhone(cellPhone);
            transactionService.balanceTransfer(amount, fromAccountAppUser, toAccountAppUser, channelType);
            return response(StatusMessage.BALANCE_TRANSFER_SUCCSS);
        } catch (Exception e) {
            return response(StatusMessage.BALANCE_TRANSFER_FAILED);
        }
    }
}
