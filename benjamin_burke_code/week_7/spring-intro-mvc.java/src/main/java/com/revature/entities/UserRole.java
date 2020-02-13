package com.revature.entities;

public enum UserRole {

    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"), LOCKED("Locked");

    private String roleName;

    UserRole(String name) {
        this.roleName = name;

    }

    @Override
    public String toString(){
        return this.roleName;
    }
}
