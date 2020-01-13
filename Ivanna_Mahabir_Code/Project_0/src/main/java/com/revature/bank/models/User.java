package com.revature.bank.models;

import java.util.Objects;

public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String usrName;
    private String passWord;

    public User(){
        super();
    }

    public User(String usrName, String passWord) {
        this.usrName = usrName;
        this.passWord = passWord;
    }

    public User(Integer userId, String firstName, String lastName, String usrName, String passWord) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.usrName = usrName;
        this.passWord = passWord;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(usrName, user.usrName) &&
                Objects.equals(passWord, user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, usrName, passWord);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", usrName='" + usrName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
