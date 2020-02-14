package com.revature.quizzard.entities;

public enum UserRole {
    ADMIN("Admin"), DEV("Dev"), BASIC("Basic User"), LOCKED("Locked");

    private String roleName;

    private UserRole(String roleName) {
        this.roleName=roleName;
    }
    public static UserRole getByName(String name) {
        for (UserRole role : UserRole.values()) {
            if (role.roleName == name) {
                return role;
            }
        }
        return LOCKED;
    }
}
