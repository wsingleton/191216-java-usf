package com.revature.models;

public enum Role{
    ADMIN, DEV, TESTER, MEMBER;

    public static Role getRoleByID(int id){
        Role role = null;
        switch (id){
            case 1:
                role = Role.ADMIN;
                break;
            case 2:
                role = Role.DEV;
                break;
            case 3:
                role = Role.TESTER;
                break;
            case 4:
                role = Role.MEMBER;
                break;
        }
        return role;
    }
}