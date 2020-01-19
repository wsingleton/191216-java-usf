package com.ers.liberation.models;

public enum Role {

    EMPLOYEE("Employee"),FINANCE_MANAGER("Manager"),CFO("Chief Financial Manager");


    private String roleName;

    Role(String roleName){this.roleName = roleName;}

    public static Role getRoleById(Integer Id){
        Role role = null;
        switch (Id){
            case 1:
            role = CFO;
            break;
            case 2:
                role= FINANCE_MANAGER;
                break;
            case 3:
                role = EMPLOYEE;
                break;

        }
        return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
