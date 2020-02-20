package com.revature.models;

public enum Role {

    MANAGER("Manager"), CUSTOMER("Customer"), ARTIST("Artist"), VENDOR("Vendor");

    private String roleName;

    Role(String name) {
        this.roleName = name;
    }

    @Override
    public String toString() {
        return this.roleName;
    }

}
