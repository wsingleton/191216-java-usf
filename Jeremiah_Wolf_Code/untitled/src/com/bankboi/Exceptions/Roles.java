package com.bankboi.Exceptions;

public enum Roles {
    ADMIN("Admin"), CUSTOMER("Customer");

    private String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() { return roleName; }
}
