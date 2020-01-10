package com.fauxnancials.models;

import java.util.Objects;

public class User {
    private int userID;
    private String username;
    private int passHash;
    private String givenName;
    private String familyName;
    private UserType userType;
    public User(String username, int passHash, String givenName, String familyName) {
        this.username = username;
        this.passHash = passHash;
        this.givenName = givenName;
        this.familyName = familyName;
    }
    public User(int userID, String username, int passHash, String givenName, String familyName, UserType userType) {
        this.userID = userID;
        this.username = username;
        this.passHash = passHash;
        this.givenName = givenName;
        this.familyName = familyName;
        this.userType=userType;
    }
    public User() {

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
    public int getPassHash() {
        return passHash;
    }
    public void setPassHash(int passHash) {
        this.passHash = passHash;
    }
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    public String getFamilyName() {
        return familyName;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID &&
                passHash == user.passHash &&
                Objects.equals(username, user.username) &&
                Objects.equals(givenName, user.givenName) &&
                Objects.equals(familyName, user.familyName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userID, username, passHash, givenName, familyName);
    }
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", passHash=" + passHash +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}