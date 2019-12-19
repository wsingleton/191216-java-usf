package com.revature.models;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;

    public User(){
        super();
    }

    public User(String fn, String ln, String username, String pw, Role role ){

        firstName =fn;
        this.lastName=ln;
        this.username= username;

    }
}
