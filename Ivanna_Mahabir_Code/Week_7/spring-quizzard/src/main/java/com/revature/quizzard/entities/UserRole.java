package com.revature.quizzard.entities;

public enum UserRole {
    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"), LOCKED("Locked");

    private String roleName;

    public static UserRole getByName(String name) {
        for (UserRole role : UserRole.values()) {
            if (role.roleName == name) {
                return role;
            }
        }
        return LOCKED;
    }

    UserRole(String name) {
        this.roleName = name;
    }

    @Override
    public String toString() {
        return this.roleName;
    }
}
