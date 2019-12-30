package com.revature.mockBank;

import java.util.Objects;

public class UserAccount {

    private String userName;
    private String password;
    private double balance;

    public UserAccount(String userName, String password, double balance) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
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
        UserAccount that = (UserAccount) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, balance);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
