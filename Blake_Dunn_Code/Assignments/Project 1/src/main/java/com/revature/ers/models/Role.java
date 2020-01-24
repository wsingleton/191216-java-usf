package com.revature.ers.models;

public enum Role {

    ADMIN (1, "Admin"), MANAGER (2, "Manager"), EMPLOYEE (3,"Employee");

    private int id;
    private String role;

    Role(Integer id, String role) {

        this.id = id;
        this.role = role;
    }

    public static Role getById(int id) {

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

    public int getRoleId(){
        return id;
    }

    @Override
    public String toString() {
        return role;
    }
}
