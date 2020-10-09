package com.zingpay.util;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

public enum AccountType {
    VIRTUAL_AGENT(1, "VIRTUAL_AGENT", "Virtual Agent"),
    RETAILER(2, "RETAILER", "Retailer"),
    SUPER_SUPER_REP(3, "SUPERSUPERREP", "ZingPay executive user"),
    SUPER_REP(4, "SUPERREP", "Executive User"),
    REP(5, "REP", "Reep user");

    private AccountType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
