package com.revature.mockERS.models;

public enum ERS_User_Roles {
    FINANCE_MANAGER(2, "Finance_Manager"), USER(1,"User");

    private String roleName;
    private Integer id;

    //enum constructors are implicitly private
    ERS_User_Roles(Integer id, String name){
        this.roleName = name;
        this.id = id;
    }

    public static ERS_User_Roles getRoleById(Integer id){
        ERS_User_Roles role = null;
        switch (id){
            case 1:
                role = ERS_User_Roles.USER;
                break;
            case 2:
                role = ERS_User_Roles.FINANCE_MANAGER;
                break;
        }
        return role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  roleName;
    }
}
