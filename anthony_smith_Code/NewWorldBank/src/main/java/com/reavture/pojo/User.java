package com.reavture.pojo;

import java.util.Objects;

public class User {

    private int user_id;
    private String username;
    private String email;
    private String lastname;
    private String firstname;
    private String password;

    public User(String username, String email, String lastName, String firstName, String password) {
        this.username = username;
        this.email = email;
        this.lastname = lastName;
        this.firstname = firstName;
        this.password = password;
    }

    public  User(){

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(user_id, user.user_id) &&
//                Objects.equals(username, user.username) &&
//                Objects.equals(email, user.email) &&
//                Objects.equals(lastname, user.lastname) &&
//                Objects.equals(firstname, user.firstname) &&
//                Objects.equals(password, user.password);
//    }

  //  @Override
//    public int hashCode() {
//        return Objects.hash(user_id, username, email, lastname, firstname, password);
    }


//    @Override
//    public String toString() {
//        return "User{" +
//                "user_id=" + user_id +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", firstname='" + firstname + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }

