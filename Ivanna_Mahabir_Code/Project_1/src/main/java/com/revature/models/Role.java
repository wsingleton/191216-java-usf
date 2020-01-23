package com.revature.models;

public enum Role {
    FINANCE_MANAGER("Finance Manager"), EMPLOYEE("Employee");

    private String roleName;

    Role(String name) {this.roleName = name;}

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

    @Override
    public String toString() {
        return roleName;
    }
}
