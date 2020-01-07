package models;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private int passHash;
    private String givenName;
    private String familyName;
    private UserClass userClass;
    public User(int id, String username, int passHash, String givenName, String familyName, UserClass userClass) {
        this.id = id;
        this.username = username;
        this.passHash = passHash;
        this.givenName = givenName;
        this.familyName = familyName;
        this.userClass=userClass;
    }
    public User(String username, int passHash, String givenName, String familyName) {
        this.username = username;
        this.passHash = passHash;
        this.givenName = givenName;
        this.familyName = familyName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public UserClass getUserClass() {
        return userClass;
    }
    public void setUserClass(UserClass userClass) {
        this.userClass = userClass;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                passHash == user.passHash &&
                Objects.equals(username, user.username) &&
                Objects.equals(givenName, user.givenName) &&
                Objects.equals(familyName, user.familyName) &&
                userClass == user.userClass;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, passHash, givenName, familyName, userClass);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passHash=" + passHash +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", userClass=" + userClass +
                '}';
    }
}
