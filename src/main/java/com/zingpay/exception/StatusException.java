package com.zingpay.exception;

import com.zingpay.util.StatusMessage;

/**
 * @author Bilal Hassan on 09-Sep-2020
 * @project zingpay-ms
 */

public class StatusException extends RuntimeException{
    private String message;
    private StatusMessage statusMessage;

    public StatusException(StatusMessage statusMessage) {
        super(statusMessage.getDescription());
        this.message = statusMessage.getDescription();
        this.statusMessage = statusMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StatusMessage getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(StatusMessage statusMessage) {
        this.statusMessage = statusMessage;
    }
}

