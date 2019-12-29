package com.fauxnancials.resources;

import java.util.Objects;

public class User {
    private String username;
    private int passHash;

    public User (String username, String password) {
        this.username = username;
        this.passHash = password.hashCode();
    }
    public User (String username, int passHash) {
        this.username=username;
        this.passHash=passHash;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return passHash == user.passHash &&
                Objects.equals(username, user.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username, passHash);
    }
    @Override
    public String toString() {
        return "User{" +
                "username: '" + username + '\'' +
                ", passHash: " + passHash +
                '}';
    }
}
