package com.revature.models;

import java.util.Objects;

public class User {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole userRole;


    public User() {
        id = 0;
        username = "";
        password = "";
        firstName = "";
        lastName = "";
        email = "";
        userRole = UserRole.EMPLOYEE;
    }

    public User(String username, String password, String firstName, String lastName) {
        id = 0;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        userRole = UserRole.EMPLOYEE;
    }


    public User(String username, String password, String firstName, String lastName, UserRole userRole) {
        id = 0;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        this.userRole = userRole;
    }

    public User(Integer id, String username, String password, String firstName, String lastName, UserRole userRole) {
        this.id = id;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        this.userRole = (userRole != null) ? userRole : UserRole.EMPLOYEE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, email, userRole);
    }
}