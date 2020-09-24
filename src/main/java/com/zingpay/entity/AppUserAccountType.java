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
@Table(name = "user_account_type")
public class AppUserAccountType {
    @Id
    @Column(name = "user_account_type_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userAccountTypeId;

    @Column(name = "account_type_value")
    private String accountTypeValue;

    @Column(name = "description")
    private String description;
}
