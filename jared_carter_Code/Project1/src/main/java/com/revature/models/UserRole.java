package com.revature.models;

public enum UserRole {

    MANAGER(1, "Manager"), EMPLOYEE(2, "Employee"), LOCKED(3, "Locked");

    private int id;
    private String name;

    UserRole(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public static UserRole getById(int id) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.id == id) {
                return userRole;
            }
        }
        return UserRole.LOCKED;
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
