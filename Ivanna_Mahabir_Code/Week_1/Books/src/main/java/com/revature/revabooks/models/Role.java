package com.revature.revabooks.models;

public enum Role {
    ADMIN("Admin"), MEMBER("Member"), PREMIUM_MEMBER("Premium Member"), MANAGER("Manager");

    private String roleName;

    //enum constructors are implicitly private
    Role(String name){
        this.roleName = name;
    }
    @Override
    public String toString(){
        return roleName;
    }
}
