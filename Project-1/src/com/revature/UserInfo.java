//Pojo UserInfo

package com.revature;

import javax.swing.*;
import java.util.Objects;

public class UserInfo {

    public UserInfo() {
        super();
    }
    private String username;
    private String password;
    private double balance;

    public UserInfo(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
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

    public String addToStored() {
        return username + ":" + password + " Your current balance is : " + balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Double.compare(userInfo.balance, balance) == 0 &&
                username.equals(userInfo.username) &&
                password.equals(userInfo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, balance);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

}
