package com.revature.ers.models;

public enum Role {

    MANAGER(1, "Manager"), USER(2,"User");

    private int id;
    private String name;

    Role(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public static Role getByID(int id){
        for (Role role : Role.values()){
            if(role.id == id){
                return role;
            }
        }
        return Role.USER;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return name;
    }
}
