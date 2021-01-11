package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Bilal Hassan on 11-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BundleDetailsDto {
    private String[] categories;
    private List<BundleDto> bundleDto;
}
