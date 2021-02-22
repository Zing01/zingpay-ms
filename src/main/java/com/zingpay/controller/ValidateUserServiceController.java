package com.zingpay.controller;

import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.WalletService;
import com.zingpay.util.AccountStatus;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 29-Oct-20
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/validate/service")
@Api(value = "validateuser", description = "Controller for validate user")
public class ValidateUserServiceController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private WalletService walletService;

    @ApiOperation(value = "Validate user on bill payment by account id and amount.", response = Status.class)
    @GetMapping("/user/{accountId}/amount/{amount}")
    public Status validateUser(@RequestHeader("Authorization") String token,
                                      @PathVariable("accountId") int accountId,
                                      @PathVariable("amount") double amount) {
        AppUser appUser = appUserService.getById(accountId);
        double balance = walletService.getCurrentBalance(accountId);
        if(appUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
            if(balance < amount) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            return new Status(StatusMessage.SUCCESS);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }
    }
}
