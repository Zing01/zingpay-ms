package com.zingpay.service;

import com.zingpay.entity.Bundle;
import com.zingpay.repository.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@Service
@Transactional
public class BundleService {

    @Autowired
    private BundleRepository bundleRepository;

    public List<Bundle> getBundles(String network) {
        return bundleRepository.findAllByNetwork(network);
    }
}
