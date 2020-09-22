package com.zingpay.util;

import org.springframework.http.HttpStatus;

/**
 * @author Bilal Hassan on 09-Sep-2020
 * @project ZingPay
 */

public enum StatusMessage {
    FAILURE(0,"FAILURE", HttpStatus.NOT_FOUND),
    SUCCESS(1,"SUCCESS", HttpStatus.OK),
    ACCOUNT_ACTIVATED_SUCCESS(2,"Account Activated Successfully", HttpStatus.OK),
    TPIN_GENERATED_SUCCESS(3,"TPin generated Successfully", HttpStatus.OK),
    EMAIL_SENT_SUCCESSFULLY(4,"Email sent Successfully", HttpStatus.OK),
    EMAIL_PIN_VALIDATION_SUCCESS(5,"Email Pin validated Successfully", HttpStatus.OK),
    PASSWORD_RESET_SUCCESS(6,"Password reset Successfully", HttpStatus.OK),
    ACCOUNT_SETUP_SUCCESS(7,"Account setup Successfully", HttpStatus.OK),

    PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED(50001, "Password and confirm password fields not matched", HttpStatus.INTERNAL_SERVER_ERROR),
    MOBILE_NUMBER_NOT_VALID(50002, "Please enter a valid mobile number", HttpStatus.INTERNAL_SERVER_ERROR),
    CNIC_NOT_VALID(50003, "Please enter a valid cnic", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_ADDRESS_NOT_VALID(50003, "Please enter a valid email address", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_PIN_NOT_VALID(50004, "Please enter a valid email pin", HttpStatus.INTERNAL_SERVER_ERROR),
    TPIN_GENERATED_FAILED(50005,"Unable to generate TPin", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_SENT_FAILED(50006,"Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR),
    PASSWORD_RESET_FAILED(50007,"Unable to reset Password", HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    private StatusMessage(int id, String description, HttpStatus statusCode) {
        this.id = id;
        this.description = description;
        this.statusCode = statusCode;
    }
    private int id;
    private String description;
    private HttpStatus statusCode;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
