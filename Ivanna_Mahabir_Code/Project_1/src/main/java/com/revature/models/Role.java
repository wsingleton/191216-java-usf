package com.revature.models;

public enum Role {
    FINANCE_MANAGER(1, "Finance Manager"), EMPLOYEE(2, "Employee");

    private int id;
    private String roleName;

    Role(Integer id, String name) {
        this.id = id;
        this.roleName = name;
    }

    public static Role getRoleById(int id){
        Role role = null;

        switch(id){
            case 1:
                role = Role.FINANCE_MANAGER;
                break;

            default:
                role = Role.EMPLOYEE;
        }
        return role;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
