package com.revature.mockbank.models;

public enum Role {
    ADMIN("Admin"), CUSTOMER("Customer");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() { return roleName; }
}
