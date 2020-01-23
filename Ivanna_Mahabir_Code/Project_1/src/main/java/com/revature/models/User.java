package com.revature.models;

import java.util.Objects;

public class User {
    private Integer user_id;
    private String user_name;
    private String pass_word;
    private String first_name;
    private String last_name;
    private String user_email;
    private Role role;

    public User(){ super(); }

    public User(String user_name, String pass_word, String first_name,
                String last_name, String user_email) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_email = user_email;
    }

    public User(Integer user_id, String user_name, String pass_word,
                String first_name, String last_name, String user_email, Role role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_email = user_email;
        this.role = role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) &&
                Objects.equals(user_name, user.user_name) &&
                Objects.equals(pass_word, user.pass_word) &&
                Objects.equals(first_name, user.first_name) &&
                Objects.equals(last_name, user.last_name) &&
                Objects.equals(user_email, user.user_email) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_name, pass_word, first_name, last_name, user_email, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", role=" + role +
                '}';
    }
}
