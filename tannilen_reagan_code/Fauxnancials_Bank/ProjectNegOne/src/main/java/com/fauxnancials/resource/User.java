package com.fauxnancials.resource;

import java.util.Objects;

public class User {
    private String username;
    private int passHash;
    private int balance;

    public User (String username, String password) {
        this.username = username;
        this.passHash = password.hashCode();
        this.balance = 0;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getPassHash() {
        return passHash;
    }
    public void setPassHash(int passHash) {
        this.passHash = passHash;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return passHash == user.passHash &&
                balance == user.balance &&
                Objects.equals(username, user.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username, passHash, balance);
    }
    @Override
    public String toString() {
        return "User{" +
                "username: '" + username + '\'' +
                ", passHash: " + passHash +
                ", balance: " + balance +
                '}';
    }
}
