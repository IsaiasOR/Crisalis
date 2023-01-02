package com.Bootcamp.Crisalis.enums;

public enum ActiveService {
    YES("Yes"),
    NO("No");

    private final String service;

    private ActiveService(String service) {
        this.service = service;
    }

    public String service() {
        return service;
    }
}
