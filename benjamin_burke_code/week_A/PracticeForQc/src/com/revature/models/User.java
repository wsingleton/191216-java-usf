package com.revature.models;
import com.revature.PracticeDriver;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role;

    public User() {super();}

    public User(String fn, String ln, String username, String em, String pw, Role role) {

        firstName = fn;
        this.lastName = ln;
        this.username=username;
        this.email=em;
        this.password=pw;
        this.role=role;

    }





}
