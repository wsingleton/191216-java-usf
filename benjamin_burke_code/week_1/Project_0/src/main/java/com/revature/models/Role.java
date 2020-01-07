package com.revature.models;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"), CUSTOMER("Customer");

    private String roleName;

     Role(String name){
        this.roleName = name;
    }

    @Override
    public String toString(){
         return roleName;
    }
}
