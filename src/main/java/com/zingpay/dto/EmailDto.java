package com.zingpay.dto;

import lombok.Data;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project zingpay-ms
 */

@Data
public class EmailDto {
    private String to;
    private String text;
    private String subject;
    private FileSystemResource file;
}
