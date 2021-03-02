package com.zingpay.feign;

import com.zingpay.dto.CardWallaBundleDto;
import com.zingpay.util.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Bilal Hassan on 01-Mar-21
 * @project zingpay-ms
 */

@FeignClient(value = "${feign.cardwallaintegration.name}", url = "${feign.cardwallaintegration.url:#{null}}")
public interface CardWallaIntegrationClient {
    @PostMapping("/product")
    Status subscribeBundle(@RequestHeader(name = "Authorization") String token, @RequestBody CardWallaBundleDto cardWallaBundleDto);
}
