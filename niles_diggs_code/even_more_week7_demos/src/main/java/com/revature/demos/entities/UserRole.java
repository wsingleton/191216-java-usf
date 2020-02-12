package com.revature.demos.entities;

public enum UserRole {
    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basci_user"), LOCKED("Locked");

    private String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }
}
