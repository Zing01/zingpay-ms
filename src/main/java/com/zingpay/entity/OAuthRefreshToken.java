package com.zingpay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bilal Hassan on 9/21/2020
 * @project zingpay-ms
 */

@Entity
@Table(name = "oauth_refresh_token")
public class OAuthRefreshToken {
    @Id
    @Column(name = "token_id")
    private String tokenId;
    @Column(name = "token")
    private String token;
    @Column(name = "authentication")
    private byte[] authentication;
}
