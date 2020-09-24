package com.zingpay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Bilal Hassan on 9/23/2020
 * @project zingpay-ms
 */

@Entity
@Getter
@Setter
@Table(name = "organization_branch")
public class OrganizationBranch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int branchId;

    @Column(name = "organization_id")
    private int organizationId;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_default")
    private boolean isDefault;

    @Column(name = "default_retailer_group_id")
    private int defaultRetailerGroupId;
}
