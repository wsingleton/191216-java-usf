package com.revature.models;

import com.revature.ObjectDriver;

import java.util.Objects;

// All classes that do not explicitly extend another class, will implicitly extend Object
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;

    /*

        Constructors are invoked to create a new instance of a class. We can include as many constructors as we need
        to give us various ways to instantiate the same class, depending on what states we want to initialize.

        Constructor overloading - including multiple constructors within the same class
        Constructor chaining - calling a constructor belonging to the same class, within another constructor for that class

        super - a keyword which is used to invoke members belonging to the parent class (constructors, fields, etc.)
        this - a keyword which is used to invoke members belonging to THIS particular instance

     */
    public User() {
        super();
    }

    public User(String fn, String ln, String username, String pw, Role role) {

        // a call to the super class's constructor is implicitly here if it not provided
//        super();

        firstName = fn; // "this" is not required if no parameters match the field name
        this.lastName = ln; // you can still include it though
        this.username = username; // here we must use "this" to clarify which one we are referencing
        password = pw;
        this.role = role;
    }

    public User(int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role); // constructor chaining
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        // optional validation logic can be included in setters
        if (lastName.equals("")) {
            return;
        }

        this.lastName = lastName;
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
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

}
