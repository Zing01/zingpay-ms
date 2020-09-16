package com.zingpay.exception;

/**
 * @author Bilal Hassan on 09-Sep-2020
 * @project ZingPay
 */

public class CustomFeignException extends Exception {

    public CustomFeignException(String response) {
        super(response);
    }
}
