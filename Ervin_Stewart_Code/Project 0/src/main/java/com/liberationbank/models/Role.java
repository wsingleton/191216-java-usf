package com.liberationbank.models;

public enum Role {

    ADMIN("Admin"),BASIC_MEMBER("Basic Member");

    private String roleName;
    Role(String roleName){this.roleName=roleName;}

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
