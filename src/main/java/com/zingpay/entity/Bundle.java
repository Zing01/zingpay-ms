package com.zingpay.entity;

import com.zingpay.dto.BundleDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@Entity
@Getter
@Setter
@Table(name = "bundle")
public class Bundle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "network")
    private String network;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "offer_key1")
    private String offerKey1;

    @Column(name = "offer_key2")
    private String offerKey2;

    @Column(name = "resources")
    private String resources;

    @Column(name = "price")
    private String price;

    @Column(name = "validity")
    private String validity;

    @Column(name = "type")
    private String type;

    public static BundleDto convertToDto(Bundle bundle) {
        BundleDto bundleDto = new BundleDto();
        bundleDto.setId(bundle.getId());
        bundleDto.setNetwork(bundle.getNetwork());
        bundleDto.setName(bundle.getName());
        bundleDto.setDescription(bundle.getDescription());
        bundleDto.setOfferKey1(bundle.getOfferKey1());
        bundleDto.setOfferKey2(bundle.getOfferKey2());
        bundleDto.setResources(bundle.getResources());
        bundleDto.setPrice(bundle.getPrice());
        bundleDto.setValidity(bundle.getValidity());
        bundleDto.setType(bundle.getType());
        return bundleDto;
    }

    public static List<BundleDto> convertToDto(List<Bundle> bundles) {
        List<BundleDto> bundleDtos = new ArrayList<BundleDto>();
        bundles.forEach(bundle -> {
            bundleDtos.add(convertToDto(bundle));
        });
        return bundleDtos;
    }
}
