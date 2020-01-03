package com.revature.revabook.models;

public enum Role {

    ADMIN, MANAGER, PREMIUM_MEMBER, BASIC_MEMBER;

    private String roleName;


    // enum constructors are implicitly private
    private Role(String name) {
        this.roleName = name;

    }

    @Override
    public String toString() {
        return roleName;
    }


}
