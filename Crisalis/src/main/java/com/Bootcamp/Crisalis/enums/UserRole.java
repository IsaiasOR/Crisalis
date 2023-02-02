package com.Bootcamp.Crisalis.enums;

public enum UserRole {
    ADMINISTRATOR("Administrator"),
    USER("User");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}