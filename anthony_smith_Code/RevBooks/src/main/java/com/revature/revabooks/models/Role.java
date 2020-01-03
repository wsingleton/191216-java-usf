package com.revature.revabooks.models;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"), PREMIUM_MEMBER("Premium Member"),
    BASIC_MEMBER("Basic Member");

    private String roleName;

    //enum constructor
    Role(String name){
        this.roleName = name;

    }

    @Override
    public String toString(){
        return roleName;
    }

}
