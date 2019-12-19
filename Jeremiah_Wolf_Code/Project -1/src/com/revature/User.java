package com.revature;

import java.util.Objects;

public class User { private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;

    public User(){
        super();
    }

    public User(String fn,String ln, String username, String pw, Role role) {
        firstName = fn;
        this.lastName = ln;
        this.username = username;
        password = pw;
        this.role = role;
    }

    public User(int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role);
        this.id = id;
    }

    public int getId(){ return id; }

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
