package com.bank.models;

import java.util.Objects;

public class User {

    private int iD;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;



    public User() {
        super();
    }

    public User(String un, String pw) {

        this.userName = un;
        this.password = pw;
    }

    public User(String un, String pw, String fn, String ln) {

        this(un, pw);
        this.firstName = fn;
        this.lastName = ln;

    }

    public User(int id, String un, String pw, String fn, String ln) {

        this(un, pw, fn, ln);
        iD = id;
    }

    public static int createId() {

        int x = (int) (Math.random() * ((99999999 - 0) + 1));
        return x;
    }

    public static void register() {

    }

    public String toFileStringUser() {
        return iD + ":" + userName + ":" + password + ":"
                + firstName + ":" + lastName;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return iD == user.iD &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, userName, password, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "iD=" + iD +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
