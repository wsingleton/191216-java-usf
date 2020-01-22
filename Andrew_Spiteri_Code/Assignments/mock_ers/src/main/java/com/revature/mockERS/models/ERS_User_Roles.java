package com.revature.mockERS.models;

public enum ERS_User_Roles {
    FINANCE_MANAGER("Finance_Manager"), USER("User");

    private String roleName;

    //enum constructors are implicitly private
    ERS_User_Roles(String name){
        this.roleName = name;
    }

    public static ERS_User_Roles getRoleById(Integer id){
        ERS_User_Roles role = null;
        switch (id){
            case 1:
                role = ERS_User_Roles.FINANCE_MANAGER;
                break;
            case 2:
                role = ERS_User_Roles.USER;
                break;
        }
        return role;
    }
}
