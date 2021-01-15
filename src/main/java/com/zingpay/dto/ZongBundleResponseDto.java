package com.zingpay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 06-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class ZongBundleResponseDto {
    //@JsonProperty(value="RETN")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int retn;
    //@JsonProperty(value="DESC")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;
    //@JsonProperty(value="BDPNOTAX")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double bdpnotax;
    //@JsonProperty(value="BDTAX")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double bdtax;
    //@JsonProperty(value="RECHARETAX")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double recharetax;
    //@JsonProperty(value="DISCOUNT")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double discount;
    //@JsonProperty(value="DEDUCTAMOUNT")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double deductamount;
    //@JsonProperty(value="SERVICEFEE")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double servicefee;
    //@JsonProperty(value="SERVICETAX")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double servicetax;
    //@JsonProperty(value="AIT")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double ait;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bossId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String requestId;
    //@JsonProperty(value="TRANSDATE")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long transdate;
    //@JsonProperty(value="BDNAME")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bdname;
}