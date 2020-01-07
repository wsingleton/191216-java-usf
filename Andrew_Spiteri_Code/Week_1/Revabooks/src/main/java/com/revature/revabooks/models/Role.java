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

    @Override
    public String toString(){
        return roleName;
    }
}
