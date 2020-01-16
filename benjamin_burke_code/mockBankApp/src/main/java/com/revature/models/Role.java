package com.revature.models;

public enum Role {

    ADMIN("Admin"), BASIC_MEMBER("Basic Membeer");

    private String roleName;

    Role(String roleName){this.roleName=roleName;}

    public static Role getRoleById(int id){

        Role role=null;
        switch (id){
            case 1:
                role = Role.ADMIN; break;
            case 2:
                role=Role.BASIC_MEMBER; break;
        }return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
