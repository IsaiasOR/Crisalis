package com.Bootcamp.Crisalis.enums;

public enum TypeService {
    COMMON("Common"),
    SPECIAL("Special");

    private final String service;

    private TypeService(String service) {
        this.service = service;
    }

    public String service() {
        return service;
    }
}
