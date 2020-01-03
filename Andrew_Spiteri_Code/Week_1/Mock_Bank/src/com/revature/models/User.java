package com.revature.models;

import java.util.Objects;

public class User {
    private String username, password, firstName, lastName;
    private Integer id;
    private Role role;


    public User(String fn, String ln, String username, String pw, Role role) {
        // a call to the super class's constructor is implicitly here if it not provided
        // super();

        firstName = fn; // "this" is not required if no parameters match the field name
        lastName = ln; // you can still include it though
        this.username = username; // here we must use "this" to clarify which one we are referencing
        password = pw;
        this.role = role;
    }
    public User(Integer id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role ); // constructor chaining
        this.id = id;
    }
    private void setUsername(String username){
        this.username = username;
    }
    private void setPassword(String password){
        this.password = password;
    }
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }
    private void setLastName(String lastName){
        this.lastName = lastName;
    }
    private void setId(Integer id){ this.id = id; }
    private void setRole(Role role){

    }

    public  String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Integer getID(){
        return id;
    }
    public Role getRole() {
        return role;
    }

    public String toFileString(){
        return id + "," + username + "," + hashCode() + "," + firstName + "," + lastName + "," + role + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return ";" + id +
                ","+ firstName +
                "," + lastName +
                "," + username +
                "," + password +
                "," + role +
                ';';
    }
}
