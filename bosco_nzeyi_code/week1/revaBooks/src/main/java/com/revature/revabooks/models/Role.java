package com.revature.revabooks.models;

public enum Role {

    ADMIN ("Admin"), MANAGER ("Manager"), PREMIUM_MEMBER ("Premium member"), BASIC_MEMBER ("Basic member");

    private String roleName;

    // enum constructors are implicitly private
    private Role (String name){
        this.roleName = name;
    }

//    @Override
//    public String toString (){
//
//    }
}
