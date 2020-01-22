package com.revature.mockERS.models;

import java.util.Objects;

public class ERS_Users {
    private String ersUsername, ersPassword, user_first_name, user_last_name, user_email;
    private Integer id;
    private ERS_User_Roles role;

    public ERS_Users(String ersUsername, String ersPassword, String user_first_name, String user_last_name, String user_email) {
        this.ersUsername = ersUsername;
        this.ersPassword = ersPassword;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
    }

    public ERS_Users(Integer id, String ersUsername, String ersPassword, String user_first_name, String user_last_name, String user_email) {
        this.id = id;
        this.ersUsername = ersUsername;
        this.ersPassword = ersPassword;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
    }

    public String getErsUsername() {
        return ersUsername;
    }

    public void setErsUsername(String ersUsername) {
        this.ersUsername = ersUsername;
    }

    public String getErsPassword() {
        return ersPassword;
    }

    public void setErsPassword(String ersPassword) {
        this.ersPassword = ersPassword;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERS_User_Roles getRole() {
        return role;
    }

    public void setRole(ERS_User_Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ERS_Users ers_users = (ERS_Users) o;
        return Objects.equals(ersUsername, ers_users.ersUsername) &&
                Objects.equals(ersPassword, ers_users.ersPassword) &&
                Objects.equals(user_first_name, ers_users.user_first_name) &&
                Objects.equals(user_last_name, ers_users.user_last_name) &&
                Objects.equals(user_email, ers_users.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ersPassword);
    }

    @Override
    public String toString() {
        return "ERS_Users{" +
                "ERS_username='" + ersUsername + '\'' +
                ", ERS_password='" + ersPassword + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
