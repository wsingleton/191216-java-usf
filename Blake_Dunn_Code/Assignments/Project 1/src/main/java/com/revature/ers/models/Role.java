package com.revature.ers.models;

public enum Role {

    ADMIN ("Admin"), MANAGER ("Manager"), EMPLOYEE ("Employee");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public static Role getRoleById(int id) {

        Role role = null;

        switch (id) {
            case 1:
                role = Role.ADMIN;
                break;
            case 2:
                role = Role.MANAGER;
                break;
            default:
                role = Role.EMPLOYEE;
        }

        return role;

    }
}
