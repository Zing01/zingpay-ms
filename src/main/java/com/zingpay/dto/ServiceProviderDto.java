package com.zingpay.dto;

import com.zingpay.entity.ServiceProvider;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 28-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class ServiceProviderDto {
    private int id;
    private int serviceBrokerId;
    private String serviceProviderShortName;
    private String serviceProviderDisplayName;
    private String serviceProviderType;
    private String city;
    private int sortOrder;
    private int active;

    private static ServiceProvider convertToEntity(ServiceProviderDto serviceProviderDto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setId(serviceProviderDto.getId());
        serviceProvider.setServiceBrokerId(serviceProviderDto.getServiceBrokerId());
        serviceProvider.setServiceProviderShortName(serviceProviderDto.getServiceProviderShortName());
        serviceProvider.setServiceProviderDisplayName(serviceProviderDto.getServiceProviderDisplayName());
        serviceProvider.setServiceProviderType(serviceProviderDto.getServiceProviderType());
        serviceProvider.setCity(serviceProviderDto.getCity());
        serviceProvider.setSortOrder(serviceProviderDto.getSortOrder());
        serviceProvider.setActive(serviceProviderDto.getActive());

        return serviceProvider;
    }

    public static List<ServiceProvider> convertToEntity(List<ServiceProviderDto> serviceProviderDtos) {
        List<ServiceProvider> serviceProviders = new ArrayList<ServiceProvider>();
        serviceProviderDtos.forEach(serviceProviderDto -> {
            serviceProviders.add(convertToEntity(serviceProviderDto));
        });
        return serviceProviders;
    }
}
