package com.bank.models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private int iD;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    public User() {
        super();
    }

    public User(String un, String pw) {

        this.userName = un;
        this.password = pw;
    }

    public User(String fn, String ln, String un, String pw) {

        this(un, pw);
        this.firstName = fn;
        this.lastName = ln;

    }

    public User(int id, String fn, String ln, String un, String pw) {

        this(fn, ln, un, pw);
        iD = id;
    }


    public User(int id, String fn, String ln, String un, String pw, Role role) {

        this(id, fn, ln, un, pw);
        this.role = role;

    }

    public static int createId() {

        int x = (int) (Math.random() * ((99999999 - 0) + 1));
        return x;
    }

    public static void register() {

    }

    public int getId() {
        return iD;
    }

    public void setId(int id) {
        iD = id;
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
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return iD == user.iD &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                userName.equals(user.userName) &&
                password.equals(user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, firstName, lastName, userName, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + iD +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
