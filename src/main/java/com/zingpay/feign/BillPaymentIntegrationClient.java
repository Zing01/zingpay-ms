package com.zingpay.feign;

import com.zingpay.dto.BillPaymentResponseDto;
import com.zingpay.dto.BillPaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Bilal Hassan on 23-Dec-20
 * @project zingpay-ms
 */

@FeignClient(value = "${feign.billpayment.name}", url = "${feign.billpayment.url:#{null}}")
public interface BillPaymentIntegrationClient {
    @PostMapping("/bill-payment-integration")
    BillPaymentResponseDto billPayment(@RequestHeader(name = "Authorization") String token, @RequestBody BillPaymentDto billPaymentDto);
}
