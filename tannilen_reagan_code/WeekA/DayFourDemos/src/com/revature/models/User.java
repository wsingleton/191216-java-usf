package com.revature.models;

import java.util.Objects;

public class User {
    //User states
    private int id;
    private String givenName;
    private String familyName;
    private String username;
    private String password;
    private Role role;
    //User default/no arg constructor
    public User() {
        super();
    }
    //User new registration constructor
    public User(String gn, String fn, String user, String pass, Role role) {
        this.givenName=gn;
        this.familyName=fn;
        this.username=user;
        this.password=pass;
        this.role=role;
    }
    //User returning constructor - chained from new registration
    public User(int id, String gn, String fn, String user, String pass, Role role) {
        this(gn,fn,user,pass,role);
        this.id=id;
    }
    //id getter
    public int getId() {
        return id;
    }
    //id setter
    public void setId(int id) {
        this.id = id;
    }
    //given name getter
    public String getGivenName() {
        return givenName;
    }
    //given name setter
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    //family name getter
    public String getFamilyName() {
        return familyName;
    }
    //family name setter
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    //username getter
    public String getUsername() {
        return username;
    }
    //username setter
    public void setUsername(String username) {
        this.username = username;
    }
    //password getter
    public String getPassword() {
        return password;
    }
    //password setter
    public void setPassword(String password) {
        this.password = password;
    }
    //role getter
    public Role getRole() {
        return role;
    }
    //role setter
    public void setRole(Role role) {
        this.role = role;
    }
    //.equals override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o; //casting "o" to type "user"
        return id == user.id && //validates that all content for submitted user "o" is value equivalent and therefore correct.
                Objects.equals(givenName, user.givenName) &&
                Objects.equals(familyName, user.familyName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }
    //hash code generation
    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, familyName, username, password, role);
    }
    //to-string override
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
