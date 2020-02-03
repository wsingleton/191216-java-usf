package com.revature.project1.models;

public enum Role {
    MANAGER(1, "Manager"), EMPLOYEE(2, "Employee"), LOCKED(3, "Locked");

    private int id;
    private String name;

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
        return Role.LOCKED;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
