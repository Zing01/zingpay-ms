package com.zingpay.repository;

import com.zingpay.entity.Bundle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bilal Hassan on 07-Jan-21
 * @project zingpay-ms
 */

@Repository
public interface BundleRepository extends BaseRepository<Bundle, Integer> {
    List<Bundle> findAllByNetwork(String network);

    List<Bundle> findAllByNetworkAndType(String network, String type);
}