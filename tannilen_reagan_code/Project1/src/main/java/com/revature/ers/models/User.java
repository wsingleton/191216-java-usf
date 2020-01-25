package com.revature.ers.models;

import java.util.Objects;

public class User {
    private int userID;
    private String username;
    private String passHash;
    private String first;
    private String last;
    private String email;
    private int role;

    public User() {
    }

    public User(int userID, String username, String passHash, String first, String last, String email, int role) {
        this.userID = userID;
        this.username = username;
        this.passHash = passHash;
        this.first = first;
        this.last = last;
        this.email = email;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID &&
                role == user.role &&
                Objects.equals(username, user.username) &&
                Objects.equals(passHash, user.passHash) &&
                Objects.equals(first, user.first) &&
                Objects.equals(last, user.last) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, passHash, first, last, email, role);
    }

    @Override
    public String toString() {
        String roleName;
        switch (role) {
            case 1:
                roleName="finance manager";
                break;
            default:
                roleName="employee";
                break;
        }
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", passHash='" + passHash + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", role=" + roleName +
                '}';
    }
}
