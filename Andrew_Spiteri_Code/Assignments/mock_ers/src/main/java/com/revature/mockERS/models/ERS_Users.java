package com.revature.mockERS.models;

import java.util.Objects;

public class ERS_Users {
    private String ERS_username, ERS_password, user_first_name, user_last_name, user_email;

    public ERS_Users(String ERS_username, String ERS_password, String user_first_name, String user_last_name, String user_email) {
        this.ERS_username = ERS_username;
        this.ERS_password = ERS_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
    }

    public String getERS_username() {
        return ERS_username;
    }

    public void setERS_username(String ERS_username) {
        this.ERS_username = ERS_username;
    }

    public String getERS_password() {
        return ERS_password;
    }

    public void setERS_password(String ERS_password) {
        this.ERS_password = ERS_password;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ERS_Users ers_users = (ERS_Users) o;
        return Objects.equals(ERS_username, ers_users.ERS_username) &&
                Objects.equals(ERS_password, ers_users.ERS_password) &&
                Objects.equals(user_first_name, ers_users.user_first_name) &&
                Objects.equals(user_last_name, ers_users.user_last_name) &&
                Objects.equals(user_email, ers_users.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ERS_password);
    }

    @Override
    public String toString() {
        return "ERS_Users{" +
                "ERS_username='" + ERS_username + '\'' +
                ", ERS_password='" + ERS_password + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
