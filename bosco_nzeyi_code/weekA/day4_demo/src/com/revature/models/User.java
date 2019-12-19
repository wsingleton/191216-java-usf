package com.revature.models;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    // this constructor method will be used to call the super class. The parent class.
    // we will overload this this method with several other ways depending on how we want to interact with our users.
    public User () {
        super();
    }

    public User (String fn, String ln, String un, String pw, Role role){
        // a call to super class is implicitly here on the first line whether you call it or not
        // super();
        firstName = fn; // similar to saying this.firstname = fn. usually done if the class properties have the same names as parameters passed in the method
        lastName = ln;
        userName = un;
        password = pw;
        this.role = role;
    }

    // let's overload the same method to be able to call a user constructor which gives us access to
    // in id
    public User ( int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role); // this is called constructor chaining. We use it as we had already used the constructor above to call the super class. So we don't want to repeat ourselves
        this.id = id;
    }

    // the setters and getters below were inserted using a quick keyboard command: command + insert;
    // in a menu that pops up, and we select all options in the setters and getters.

    // For more on how this is done, explore Pojo structure.
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
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getUserName().equals(user.getUserName()) &&
                getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUserName(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
