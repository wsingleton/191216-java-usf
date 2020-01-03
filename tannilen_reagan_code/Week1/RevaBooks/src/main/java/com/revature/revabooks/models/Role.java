package com.revature.revabooks.models;

public enum Role {
    ADMIN("Admin"), MANAGER("Manager"), PREMIUM_MEMBER("Premium Member"),
    BASIC_MEMBER("Basic Member");
    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}