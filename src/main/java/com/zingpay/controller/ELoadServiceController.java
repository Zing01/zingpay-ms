package com.zingpay.controller;

import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.WalletService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
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

    @GetMapping("/user/{accountId}/amount/{amount}")
    public Status validateUserOnEload(@RequestHeader("Authorization") String token,
                                      @PathVariable("accountId") int accountId,
                                      @PathVariable("amount") double amount) {
        AppUser appUser = appUserService.getById(accountId);
        double balance = walletService.getCurrentBalance(accountId);
        if(appUser.getAccountStatusId() == 1) {
            if(balance < amount) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            return new Status(StatusMessage.SUCCESS);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }
    }
}
