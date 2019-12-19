package com.revature.models;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    //Constructor Overloading: Having multiple constructors help you create User's in a variety of ways.

    //constructor 1: No-args constructor
    public User() {
        super(); //calling the object classes constructor. Must be called in first line.
    }

    //constructor 2: Args constructor
    public User(String firstName, String lastName, String userName, String pw, Role role) {
        //when you have parameters that have the name of instance you will need to set its value using this keyword
        //

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        password = pw; //Because the parameter has a different name follow this format
        this.role = role;
    }

    //constructor 3: Constructor chaining - only difference it is setting the id in this constructor
    public User(int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role); // constructor chaining calls must be made on the first line. Can't be used with super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void getLastName() {
        //Optional validation logic can be included in setters
        if(lastName.equals("")) {
            return;
        }

        this.lastName = lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
