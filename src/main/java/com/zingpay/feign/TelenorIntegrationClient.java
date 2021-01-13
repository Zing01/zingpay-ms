package com.zingpay.feign;

import com.zingpay.dto.TelenorBundleDto;
import com.zingpay.dto.TelenorLoadDto;
import com.zingpay.dto.TelenorLoadResponseDto;
import com.zingpay.util.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Bilal Hassan on 16-Dec-20
 * @project zingpay-ms
 */

@FeignClient(value = "${feign.telenorintegration.name}", url = "${feign.telenorintegration.url:#{null}}")
public interface TelenorIntegrationClient {
    @PostMapping("/load")
    TelenorLoadResponseDto telenorLoad(@RequestHeader(name = "Authorization") String token, @RequestBody TelenorLoadDto telenorLoadDto);

    @PostMapping("/bundle")
    Status subscribeBundle(@RequestHeader(name = "Authorization") String token, @RequestBody TelenorBundleDto telenorBundleDto);
}
