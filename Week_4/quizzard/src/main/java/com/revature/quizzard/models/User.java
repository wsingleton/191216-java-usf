package com.revature.quizzard.models;

import java.util.Objects;

public class User {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    public User() {
        id = 0;
        username = "";
        password = "";
        firstName = "";
        lastName = "";
        role = Role.BASIC_USER;
    }

    public User(String username, String password, String firstName, String lastName) {
        id = 0;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        role = Role.BASIC_USER;
    }

    public User(String username, String password, String firstName, String lastName, Role role) {
        id = 0;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        this.role = role;
    }

    public User(Integer id, String username, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        this.role = (role != null) ? role : Role.BASIC_USER;
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
        if (username == null) return;
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
        if (firstName == null) return;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) return;
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (role == null) return;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                username.equals(user.username) &&
                password.equals(user.password) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }

}
