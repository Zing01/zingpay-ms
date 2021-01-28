package com.zingpay.entity;

import com.zingpay.dto.ServiceProviderDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 28-Jan-21
 * @project zingpay-ms
 */

@Entity(name = "ref_service_provider")
@Getter
@Setter
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_provider_id")
    private int id;

    @Column(name = "service_broker_id")
    private int serviceBrokerId;

    @Column(name = "service_provider_short_name")
    private String serviceProviderShortName;

    @Column(name = "service_provider_display_name")
    private String serviceProviderDisplayName;

    @Column(name = "service_provider_type")
    private String serviceProviderType;

    @Column(name = "city")
    private String city;

    @Column(name = "sort_order")
    private int sortOrder;

    @Column(name = "active")
    private int active;

    private static ServiceProviderDto convertToDto(ServiceProvider serviceProvider) {
        ServiceProviderDto serviceProviderDto = new ServiceProviderDto();
        serviceProviderDto.setId(serviceProvider.getId());
        serviceProviderDto.setServiceBrokerId(serviceProvider.getServiceBrokerId());
        serviceProviderDto.setServiceProviderShortName(serviceProvider.getServiceProviderShortName());
        serviceProviderDto.setServiceProviderDisplayName(serviceProvider.getServiceProviderDisplayName());
        serviceProviderDto.setServiceProviderType(serviceProvider.getServiceProviderType());
        serviceProviderDto.setCity(serviceProvider.getCity());
        serviceProviderDto.setSortOrder(serviceProvider.getSortOrder());
        serviceProviderDto.setActive(serviceProvider.getActive());

        return serviceProviderDto;
    }

    public static List<ServiceProviderDto> convertToDto(List<ServiceProvider> serviceProviders) {
        List<ServiceProviderDto> serviceProviderDtos = new ArrayList<ServiceProviderDto>();

        serviceProviders.forEach(serviceProvider -> {
            serviceProviderDtos.add(convertToDto(serviceProvider));
        });
        return serviceProviderDtos;
    }
}
