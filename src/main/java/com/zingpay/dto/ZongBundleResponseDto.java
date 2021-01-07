package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 06-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class ZongBundleResponseDto {
    @JsonProperty(value="RETN")
    private int retn;
    @JsonProperty(value="DESC")
    private String desc;
    @JsonProperty(value="BDPNOTAX")
    private double bdpnotax;
    @JsonProperty(value="BDTAX")
    private double bdtax;
    @JsonProperty(value="RECHARETAX")
    private double recharetax;
    @JsonProperty(value="DISCOUNT")
    private double discount;
    @JsonProperty(value="DEDUCTAMOUNT")
    private double deductamount;
    @JsonProperty(value="SERVICEFEE")
    private double servicefee;
    @JsonProperty(value="SERVICETAX")
    private double servicetax;
    @JsonProperty(value="AIT")
    private double ait;
    private String bossId;
    private String requestId;
    @JsonProperty(value="TRANSDATE")
    private long transdate;
    @JsonProperty(value="BDNAME")
    private String bdname;
}