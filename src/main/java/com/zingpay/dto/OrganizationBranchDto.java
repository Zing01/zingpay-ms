package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 9/23/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class OrganizationBranchDto {
    private int branchId;
    private int organizationId;
    private String branchName;
    private String description;
    private boolean isDefault;
    private int defaultRetailerGroupId;
}
