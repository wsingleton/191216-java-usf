package com.revature.models;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"), CUSTOMER("Customer");

    private String roleName;

     Role(String name){
        this.roleName = name;
    }

    public static Role getRoleById(int id){

         Role role = null;
         switch (id) {
             case 1:
                 role = Role.ADMIN;break;
             case 2:
                 role = Role.MANAGER; break;
             default:
                 role = Role.CUSTOMER; break;
         }
         return role;
    }

    @Override
    public String toString(){
         return roleName;
    }
}
