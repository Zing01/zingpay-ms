package com.zingpay.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.zingpay.entity.Bundle;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class BundleDto {
    private int id;
    private String network;
    private String name;
    private String description;
    private String offerKey1;
    private String offerKey2;
    private ArrayNode resources;
    private String price;
    private String validity;
    private String type;

    public static Bundle convertToEntity(BundleDto bundleDto) {
        Bundle bundle = new Bundle();
        bundle.setId(bundleDto.getId());
        bundle.setNetwork(bundleDto.getNetwork());
        bundle.setName(bundleDto.getName());
        bundle.setDescription(bundleDto.getDescription());
        bundle.setOfferKey1(bundleDto.getOfferKey1());
        bundle.setOfferKey2(bundleDto.getOfferKey2());
        bundle.setResources(bundleDto.getResources().asText());
        bundle.setPrice(bundleDto.getPrice());
        bundle.setValidity(bundleDto.getValidity());
        bundle.setType(bundleDto.getType());
        return bundle;
    }

    public static List<Bundle> convertToEntity(List<BundleDto> bundleDtos) {
        List<Bundle> bundles = new ArrayList<Bundle>();
        bundleDtos.forEach(bundleDto -> {
            bundles.add(convertToEntity(bundleDto));
        });
        return bundles;
    }
}
