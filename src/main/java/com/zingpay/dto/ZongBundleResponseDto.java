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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int retn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double bdpnotax;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double bdtax;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double recharetax;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double discount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double deductamount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double servicefee;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double servicetax;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double ait;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bossId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String requestId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long transdate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bdname;
}