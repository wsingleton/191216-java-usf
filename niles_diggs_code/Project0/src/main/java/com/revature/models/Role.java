package com.revature.models;

public enum Role {
    ADMIN("admin"), MANAGER("manager"), PREMIUM("premium"), MEMBER("member");

    private String userRole;

    Role(String title) {
        this.userRole = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userRole='" + userRole + '\'' +
                '}';
    }
}


