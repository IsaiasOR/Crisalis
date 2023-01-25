package com.Bootcamp.Crisalis.enums;

public enum TypeService {
    COMMON("Common"),
    SPECIAL("Special");

    private final String type;

    TypeService(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
