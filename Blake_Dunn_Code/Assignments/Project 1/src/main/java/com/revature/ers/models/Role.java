package com.revature.ers.models;

public enum Role {

    ADMIN ("Admin"), MANAGER ("Manager"), EMPLOYEE ("Employee");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
