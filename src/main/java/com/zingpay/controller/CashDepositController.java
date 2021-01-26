package com.zingpay.controller;

import com.zingpay.dto.AppUserCashDepositDto;
import com.zingpay.dto.TransactionCashDepositDto;
import com.zingpay.entity.AppUser;
import com.zingpay.entity.Transaction;
import com.zingpay.service.AppUserService;
import com.zingpay.service.TransactionService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 26-Jan-21
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/cash-deposit")
@Api(value = "cashDeposit", description = "Controller for cashin")
public class CashDepositController extends BaseController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{cellPhone}")
    public Status userDetails(@PathVariable("cellPhone") String username) {
        AppUser appUser = appUserService.getActiveByUsername(username);
        if(appUser != null) {
            AppUserCashDepositDto appUserCashDepositDto = AppUserCashDepositDto.convertToDto(appUser);
            return new Status(StatusMessage.SUCCESS, appUserCashDepositDto);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE_OR_USER_DOES_NOT_EXIST);
        }
    }

    @PutMapping
    public Status cashDeposit(@RequestBody TransactionCashDepositDto transactionCashDepositDto) {
        try {
            AppUser appUser = appUserService.getByCellPhone(transactionCashDepositDto.getRecipientUsername());
            transactionCashDepositDto.setAccountId(appUser.getAccountId());
            Transaction transaction = TransactionCashDepositDto.convertToEntity(transactionCashDepositDto);
            transactionService.save(transaction);
            return response(StatusMessage.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response(StatusMessage.FAILURE);
    }
}
