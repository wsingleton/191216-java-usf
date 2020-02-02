package com.revature.project1.models;

public enum Role {

    ADMIN(1, "Admin"), MANAGER(2, "Manager"), EMPLOYEE(3,"Employee");

    private int id; //ers_user_role_id
    private String name; //user_role

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role getById(int id){
        for (Role role: Role.values()) {
            if (role.id == id) {
                return role;
            }
        }
        return Role.EMPLOYEE;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}