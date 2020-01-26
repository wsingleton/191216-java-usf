package com.revature.ers.models;

public enum Role {

    EMPLOYEE(1, "Employee"), MANAGER(2, "Manager");

    private int id;
    private String name;

    Role() {
    }

    Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role getById(int id) {
        for (Role role : Role.values()) {
            if (role.id == id) {
                return role;
            }
        }
        return Role.EMPLOYEE;
    }

    public int getId() { return id; }

    @Override
    public String toString() { return name; }

}
