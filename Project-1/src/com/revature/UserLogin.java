package com.revature;

/*
- need to register for a new user account (must be secured with a password)

- login with existing user account credentials

 */

import java.util.Objects;

//Pojo set up
public class UserLogin{
    private int userNum;
    private int checkingAccNum;
    private int savingsAccNum;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public UserLogin() {
        super();
    }

    public UserLogin(int userNum, int checkingAccNum, int savingsAccNum, String firstName, String lastName, String username, String password) {
        this.userNum = userNum;
        this.checkingAccNum = checkingAccNum;
        this.savingsAccNum = savingsAccNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getCheckingAccNum() {
        return checkingAccNum;
    }

    public void setCheckingAccNum(int checkingAccNum) {
        this.checkingAccNum = checkingAccNum;
    }

    public int getSavingsAccNum() {
        return savingsAccNum;
    }

    public void setSavingsAccNum(int savingsAccNum) {
        this.savingsAccNum = savingsAccNum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLogin userLogin = (UserLogin) o;
        return userNum == userLogin.userNum &&
                checkingAccNum == userLogin.checkingAccNum &&
                savingsAccNum == userLogin.savingsAccNum &&
                Objects.equals(firstName, userLogin.firstName) &&
                Objects.equals(lastName, userLogin.lastName) &&
                Objects.equals(username, userLogin.username) &&
                Objects.equals(password, userLogin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNum, checkingAccNum, savingsAccNum, firstName, lastName, username, password);
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userNum=" + userNum +
                ", checkingAccNum=" + checkingAccNum +
                ", savingsAccNum=" + savingsAccNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
