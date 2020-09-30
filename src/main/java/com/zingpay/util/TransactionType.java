package com.zingpay.util;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

public enum TransactionType {
    DEBIT(1, "DEBIT", "DEBIT"),
    CREDIT(2, "CREDIT", "CREDIT");

    private TransactionType(int id, String value, String description) {
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
