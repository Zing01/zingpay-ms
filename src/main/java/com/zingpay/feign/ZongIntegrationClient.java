package com.zingpay.feign;

import com.zingpay.dto.ZongLoadDto;
import com.zingpay.dto.ZongLoadResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Bilal Hassan on 08-Dec-20
 * @project zingpay-ms
 */

@FeignClient(value = "${feign.zong.name}", url = "${feign.zong.url:#{null}}")
public interface ZongIntegrationClient {

    @PostMapping("/load")
    ZongLoadResponseDto zongLoad(@RequestHeader(name = "Authorization") String token, @RequestBody ZongLoadDto zongLoadDto);
}
