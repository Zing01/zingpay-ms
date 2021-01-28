package com.zingpay.service;

import com.zingpay.entity.ServiceProvider;
import com.zingpay.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bilal Hassan on 28-Jan-21
 * @project zingpay-ms
 */

@Service
@Transactional
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public ServiceProvider getByServiceProviderDisplayName(String displayName) {
        return serviceProviderRepository.findByServiceProviderDisplayName(displayName);
    }
}
