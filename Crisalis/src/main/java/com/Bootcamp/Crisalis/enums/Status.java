package com.Bootcamp.Crisalis.enums;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
