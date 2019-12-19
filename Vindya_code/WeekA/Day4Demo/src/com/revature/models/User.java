package com.revature.models;

import java.util.Objects;

public class User {
    private int id;
    private String FirstName;
    private String LastName;
    private String Username;
    private String password;
    private Role role;

    public User() {
        super();

    }

    public User(String fn, String ln, String username, String pw, Role role) {
        //a call to the super class's constuctor is implicitly here if it is not provided
        //super();
        FirstName = fn;//"this " is not required if no parameters match the field name
        this.LastName = ln;// you can still include it though
        this.Username = username;
        password = pw;//here we must use "this" to clarify which one we are referencing
        this.role = role;


    }

    public User(int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role);// constructor chaining
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        if(lastName.equals("")) {
            return;
        }
            //optional validation logic can be included in setters
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return id == user.id &&
                Objects.equals(FirstName, user.FirstName) &&
                Objects.equals(LastName, user.LastName) &&
                Objects.equals(Username, user.Username) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FirstName, LastName, Username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
