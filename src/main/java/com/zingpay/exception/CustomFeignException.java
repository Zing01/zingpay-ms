package com.zingpay.exception;

/**
 * @author Bilal Hassan on 09-Sep-2020
 * @project zingpay-ms
 */

public class CustomFeignException extends Exception {

    public CustomFeignException(String response) {
        super(response);
    }
}
