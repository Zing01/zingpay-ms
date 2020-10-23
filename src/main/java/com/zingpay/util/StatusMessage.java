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
    PIN_VALIDATION_SUCCESS(5,"Pin validated Successfully", HttpStatus.OK),
    PASSWORD_RESET_SUCCESS(6,"Password reset Successfully", HttpStatus.OK),
    ACCOUNT_SETUP_SUCCESS(7,"Account setup Successfully", HttpStatus.OK),
    ACCOUNT_SETTING_SUCCESS(8,"Account settings saved Successfully", HttpStatus.OK),
    ACCOUNT_CREATION_SUCCESS(9,"Your account has been created Successfully", HttpStatus.OK),
    SMS_SENT_SUCCESSFULLY(10, "Sms Sent Successfully", HttpStatus.OK),

    PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED(5001, "Password and confirm password fields not matched", HttpStatus.INTERNAL_SERVER_ERROR),
    CELL_PHONE_NOT_VALID(5002, "Please enter a valid mobile number", HttpStatus.INTERNAL_SERVER_ERROR),
    CNIC_NOT_VALID(5003, "Please enter a valid cnic", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_NOT_VALID(5003, "Please enter a valid email address", HttpStatus.INTERNAL_SERVER_ERROR),
    PIN_NOT_VALID(5004, "Please enter a valid pin", HttpStatus.INTERNAL_SERVER_ERROR),
    TPIN_GENERATED_FAILED(5005,"Unable to generate TPin", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_SENT_FAILED(5006,"Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR),
    PASSWORD_RESET_FAILED(5007,"Unable to reset Password", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_NOT_FOUND(5008,"Email not found", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_NOT_CHANGE(5009,"You cannot change username", HttpStatus.INTERNAL_SERVER_ERROR),
    CNIC_NOT_FOUND(5010,"CNIC not found", HttpStatus.INTERNAL_SERVER_ERROR),
    FULLNAME_IS_REQUIRED(5011,"Full Name is required", HttpStatus.INTERNAL_SERVER_ERROR),
    CELL_PHONE_IS_REQUIRED(5012,"Cell Phone is required", HttpStatus.INTERNAL_SERVER_ERROR),
    EMAIL_IS_REQUIRED(5013,"Email is required", HttpStatus.INTERNAL_SERVER_ERROR),
    CNIC_IS_REQUIRED(5014,"CNIC is required", HttpStatus.INTERNAL_SERVER_ERROR),
    BUSINESS_NAME_IS_REQUIRED(5015,"Business Name is required", HttpStatus.INTERNAL_SERVER_ERROR),
    MOBILE_LOCATION_IS_REQUIRED(5016,"Mobile Location is required", HttpStatus.INTERNAL_SERVER_ERROR),
    TRANSACTION_ID_IS_REQUIRED(5017,"Transaction Id is required", HttpStatus.INTERNAL_SERVER_ERROR),
    TRANSACTION_DATE_IS_REQUIRED(5018,"Transaction Date is required", HttpStatus.INTERNAL_SERVER_ERROR),
    TRANSACTION_AMOUNT_IS_REQUIRED(5019,"Transaction Amount is required", HttpStatus.INTERNAL_SERVER_ERROR),
    ADDRESS_IS_REQUIRED(5020,"Address is required", HttpStatus.INTERNAL_SERVER_ERROR),
    HOUSE_NUMBER_IS_REQUIRED(5021,"House Number is required", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PASSWORD(5022,"Invalid Password", HttpStatus.INTERNAL_SERVER_ERROR),
    CELL_PHONE_NOT_FOUND(5023, "Please enter a valid cell phone", HttpStatus.INTERNAL_SERVER_ERROR),
    SMS_SENT_FAILED(5024, "Unable to send sms", HttpStatus.INTERNAL_SERVER_ERROR),
    ACCOUNT_NOT_ACTIVE(5025, "Account is not active", HttpStatus.INTERNAL_SERVER_ERROR),
    INSUFFICIENT_BALANCE(5026, "Insufficient balance to perform this transaction", HttpStatus.INTERNAL_SERVER_ERROR),
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
