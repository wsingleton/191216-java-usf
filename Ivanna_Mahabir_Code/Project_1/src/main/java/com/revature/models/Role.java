package com.revature.models;

public enum Role {
    MANAGER(1, "Manager"), EMPLOYEE(2, "Employee");

    private int id;
    private String roleName;

    Role(Integer id, String name) {
        this.id = id;
        this.roleName = name;
    }

    public static Role getRoleById(int id){
        for(Role role : Role.values()){
            if(role.id == id){
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
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
