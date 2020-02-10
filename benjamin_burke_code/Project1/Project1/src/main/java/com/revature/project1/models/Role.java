package com.revature.project1.models;


public enum Role {

    ADMIN(1, "Admin"), MANAGER(2, "Manager"), EMPLOYEE(3, "EMPLOYEE");

    private int id;
    private String name;

    Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role getById(int id) {
        switch (id) {
            case 1:
                return ADMIN;
            case 2:
                return MANAGER;
            default:
                return EMPLOYEE;
        }
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}