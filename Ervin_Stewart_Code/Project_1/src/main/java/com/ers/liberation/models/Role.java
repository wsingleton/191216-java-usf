package com.ers.liberation.models;

public enum Role {

    EMPLOYEE(1,"Employee"),FINANCE_MANAGER(2,"Manager"),CFO(3,"Chief Financial Manager");

    private Integer id;
    private String roleName;

    Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public static Role getById(Integer Id){
        for (Role role : Role.values()) {
            if (role.id == Id) {
                return role;
            }
        }
        return Role.EMPLOYEE;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
