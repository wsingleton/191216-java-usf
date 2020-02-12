package com.revature.quizzard.entities;

public enum UserRole {
    ADMIN("Admin"), DEV("Dev"), BASIC("Basic User"), LOCKED("Locked");

    private String roleName;

    private UserRole(String roleName) {
        this.roleName=roleName;
    }
}
