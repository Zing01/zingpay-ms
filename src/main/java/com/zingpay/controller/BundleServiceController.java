package com.zingpay.controller;

import com.zingpay.dto.BundleDto;
import com.zingpay.entity.Bundle;
import com.zingpay.service.BundleService;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/bundle/service")
@Api(value = "bundle", description = "Controller for bundles")
public class BundleServiceController {

    @Autowired
    private BundleService bundleService;

    @GetMapping("/{network}")
    public Status getBundles(@RequestHeader("Authorization") String token,
                             @PathVariable("network") String network) {
        List<Bundle> bundles = bundleService.getBundles(network);
        List<BundleDto> bundleDtos = Bundle.convertToDto(bundles);
        return new Status(StatusMessage.SUCCESS, bundleDtos);
    }
}
