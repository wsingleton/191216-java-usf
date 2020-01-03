package com.revature.fauxbank.models;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"), MEMBER("Member");

    private String roleName;

    Role(String name) {
        this.roleName = name;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
