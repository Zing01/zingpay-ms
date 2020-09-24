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
@Table(name = "user_account_status")
public class AppUserAccountStatus {
    @Id
    @Column(name = "user_account_status_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userAccountStatusId;

    @Column(name = "account_status_value")
    private String accountStatusValue;

    @Column(name = "description")
    private String description;
}
