package com.zingpay.feign;

import com.zingpay.dto.BookMeBusDto;
import com.zingpay.dto.BookMeEventDto;
import com.zingpay.util.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Bilal Hassan on 03-Mar-21
 * @project zingpay-ms
 */

@FeignClient(value = "${feign.bookmeintegration.name}", url = "${feign.bookmeintegration.url:#{null}}")
public interface BookMeIntegrationClient {
    @PostMapping("/event/event-booking")
    Status bookEvent(@RequestHeader(name = "Authorization") String token, @RequestBody BookMeEventDto bookMeEventDto);

    @PostMapping("/bus/book-seats")
    Status bookSeats(@RequestHeader(name = "Authorization") String token, @RequestBody BookMeBusDto bookMeBusDto);
}
