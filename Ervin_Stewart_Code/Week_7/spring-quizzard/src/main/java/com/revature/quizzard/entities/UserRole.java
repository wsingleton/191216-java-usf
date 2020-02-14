package com.revature.quizzard.entities;

public enum UserRole {
    ADMIN("Admin"),DEV("Dev"),BASIC_USER("Basic User"),LOCKED("Locked");
private String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
