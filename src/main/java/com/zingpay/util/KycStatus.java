package com.zingpay.util;

/**
 * @author Bilal Hassan on 18-Nov-20
 * @project zingpay-ms
 */

public enum KycStatus {
    PENDING(1, "PENDING", "Pending"),
    SUBMIT(2, "SUBMIT", "Submit"),
    APPROVE(3, "APPROVE", "Approve"),
    REJECT(4, "REJECT", "Reject");


    private KycStatus(int id, String value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    private int id;
    private String value;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
