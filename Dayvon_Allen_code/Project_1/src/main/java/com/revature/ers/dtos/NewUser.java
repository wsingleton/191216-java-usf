package com.revature.ers.dtos;

import java.util.Objects;

public class NewUser {
    private String fn;
    private String ln;
    private String un;
    private String email;
    private String password;



    public NewUser(String fn, String ln, String un, String email, String password) {
        this.fn = fn;
        this.ln = ln;
        this.un = un;
        this.email = email;
        this.password = password;
    }

    public NewUser() {
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        NewUser newUser = (NewUser) o;
        return Objects.equals(fn, newUser.fn) &&
                Objects.equals(ln, newUser.ln) &&
                Objects.equals(un, newUser.un) &&
                Objects.equals(email, newUser.email) &&
                Objects.equals(password, newUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fn, ln, un, email, password);
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "fn='" + fn + '\'' +
                ", ln='" + ln + '\'' +
                ", un='" + un + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
