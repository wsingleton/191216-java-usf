package com.fauxnancialsbank.resources;
import java.util.Objects;

public class User {
    private String username;
    private String given;
    private String family;
    private String password;
    private int acct;
    public User() {
        super();
    }
    public User(String username, String given, String family, String password) {
        this.username = username;
        this.given = given;
        this.family = family;
        this.password = password;
        String acctBase=given+family+username;
        this.acct=acctBase.hashCode();
    }
    public User(String username, String given, String family, String password, int acct) {
        this.username = username;
        this.given = given;
        this.family = family;
        this.password = password;
        this.acct = acct;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getGiven() {
        return given;
    }
    public void setGiven(String given) {
        this.given = given;
    }
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAcct() {
        return acct;
    }
    public void setAcct(int acct) {
        this.acct = acct;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return acct == user.acct &&
                Objects.equals(username, user.username) &&
                Objects.equals(given, user.given) &&
                Objects.equals(family, user.family) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, given, family, password, acct);
    }

    @Override
    public String toString() {
        return "User{" +
                "'username='" + username + '\'' +
                ", given='" + given + '\'' +
                ", family='" + family + '\'' +
                ", password='" + password + '\'' +
                ", acct=" + acct +
                '}';
    }
}
