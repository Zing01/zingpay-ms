package com.zingpay.controller;

import com.zingpay.dto.TransactionDto;
import com.zingpay.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bilal Hassan on 22-Jan-21
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/commission/service")
@Api(value = "commission", description = "Controller for commission microservice")
public class CommissionServiceController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save-commission-transactions")
    public void saveCommissionTransactions(@RequestHeader("Authorization") String token, @RequestBody List<TransactionDto> transactionDtos) {
        transactionService.saveAll(TransactionDto.convertToEntity(transactionDtos));
    }
}
