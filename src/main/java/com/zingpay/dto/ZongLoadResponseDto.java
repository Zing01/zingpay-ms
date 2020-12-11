package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bilal Hassan on 11-Dec-20
 * @project zingpay-ms
 */

@Getter
@Setter
public class ZongLoadResponseDto {
    private int retn;
    private String desc;
    private String bossId;
    private String requestId;
}
