package com.revature.entities;

public enum  Role {
    ADMIN("Admin"), DEV("Dev"), BASIC("User"), LOCKED("B8");
    private String roleName;
    Role(String name) {
        this.roleName=name;
    }
    @Override
    public String toString() {
        return this.roleName;
    }
}
