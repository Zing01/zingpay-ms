package com.zingpay.repository;

import com.zingpay.entity.ServiceProvider;
import org.springframework.stereotype.Repository;

/**
 * @author Bilal Hassan on 28-Jan-21
 * @project zingpay-ms
 */

@Repository
public interface ServiceProviderRepository extends BaseRepository<ServiceProvider, Integer> {
    ServiceProvider findByServiceProviderDisplayName(String displayName);
}
