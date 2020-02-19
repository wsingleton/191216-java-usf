package com.revature.quizzard.entities;

public enum UserRole {

    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"), LOCKED("Locked");

    private String roleName;

    UserRole(String name) {
        this.roleName = name;
    }

    public static UserRole getByName(String name) {
        for (UserRole role : UserRole.values()) {
            if (role.roleName == name) {
                return role;
            }
        }
        return LOCKED;
    }

    @Override
    public String toString() {
        return this.roleName;
    }

}
