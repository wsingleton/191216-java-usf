package com.revature.models;

import java.util.Objects;

public class User {

    private int id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private Role role;
    //classes are always singular because they represent one thing
    public User() {
        super();// The super call to the object is going to be here at the top whether you write it or not
        // and if you write it it needs to be on the first line
    }

    public User(String fn, String ln, String username, String pw, Role role) {
        this.firstName = fn; // this is not required if no field matches the parameter name;
        this.lastName = ln;// you can still include, the keyword this is a reference to this instance
        this.username = username;
        this.password = pw;
        this.role = role;
    }

    public User(int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role);// if you are going to chain a constructor the this keyword has to be first.
        // if you use the this keyword constructor it will not call the super constructor, constructor overloading,
        // also polymorphism, constructor chaining is a way to create an object in multiple ways
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
