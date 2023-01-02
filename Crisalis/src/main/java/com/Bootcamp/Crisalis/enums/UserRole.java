package com.Bootcamp.Crisalis.enums;

public enum UserRole {
    ADMIN("Administrator"),
    SUPER_ADMIN("SuperAdmin");

    private final String role;

    private UserRole(String role) {
        this.role = role;
    }

    public String returnRole() {
        return role;
    }
}