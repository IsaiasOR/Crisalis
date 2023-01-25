package com.Bootcamp.Crisalis.enums;

public enum UserRole {
    ADMIN("Administrator"),
    SUPER_ADMIN("Super administrator");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}