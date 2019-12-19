package com.revature.module;

import java.util.Objects;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String useName;
    private String password;
    private Role role;
    public User(){
        super();
    }
    public User(String fn, String ln, String userName, String password, Role role){
        // super() ; // a call to the super class,s constructor is implicitly here id it mot provided
        firstName = fn; // this is not require if no parameters match the field name
        this.lastName=ln;//you can still include it though
        this.useName = userName;// here we must use "this" to clarity which one we are refering
        this.password = password;
        this.role = role;

    }
    public User(int id, String fn, String ln, String userName, String password, Role role){
        this(fn, ln, userName, password, role);// constructor chaining
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        //optional validation logic can be included in setter
        if(lastName.equals("")){
            return;
        }
        this.lastName = lastName;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
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
                Objects.equals(useName, user.useName) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, useName, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", useName='" + useName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
