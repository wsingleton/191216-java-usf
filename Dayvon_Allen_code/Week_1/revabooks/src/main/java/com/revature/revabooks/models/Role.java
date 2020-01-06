package com.revature.revabooks.models;

public enum Role {
    //all final values
    ADMIN("Admin"), MANAGER("Manager"), PREMIUM_MEMBER("Premium Member"), BASIC_MEMBER("Basic Member");

    private String roleName;

    //constructor implicitly private
     Role(String name) {
        this.roleName = name;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
