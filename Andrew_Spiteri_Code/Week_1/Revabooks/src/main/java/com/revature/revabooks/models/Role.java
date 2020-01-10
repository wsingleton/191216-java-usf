package com.revature.revabooks.models;

public enum Role {
    ADMIN("ADMIN"), MANAGER("MANAGER"),
    PREMIUM_MEMBER("PREMIUM_MEMBER"),
    BASIC_MEMBER("BASIC_MEMBER");

    private String roleName;
    //private Integer score;

    Role(String roleName){
        this.roleName = roleName;
    }

    public static Role getRoleByID(int id){
        Role role = null;
        switch (id){
            case 1:
                role = Role.ADMIN;
                break;
            case 2:
                role = Role.MANAGER;
                break;
            case 3:
                role = Role.PREMIUM_MEMBER;
                break;
            default:
                role = Role.BASIC_MEMBER;
                break;
        }
        return role;
    }

    @Override
    public String toString(){
        return roleName;
    }
}
