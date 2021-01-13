package com.zingpay.feign;

import com.zingpay.dto.TransactionCommissionDto;
import com.zingpay.dto.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author Bilal Hassan on 12-Jan-21
 * @project zingpay-ms
 */

@FeignClient(value = "${feign.calculatecommission.name}", url = "${feign.calculatecommission.url:#{null}}")
public interface CalculateCommissionClient {
    @PostMapping("/calculate-commission")
    List<TransactionDto> calculateCommission(@RequestHeader(name = "Authorization") String token, @RequestBody TransactionCommissionDto transactionCommissionDto);
}
