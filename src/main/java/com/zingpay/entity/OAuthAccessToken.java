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
@Table(name = "oauth_access_token")
public class OAuthAccessToken {
    @Column(name = "token_id")
    private String tokenId;
    @Column(name = "token")
    private byte[] token;
    @Id
    @Column(name = "authentication_id")
    private String authenticationId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "authentication")
    private byte[] authentication;
    @Column(name = "refresh_token")
    private String refreshToken;
}
