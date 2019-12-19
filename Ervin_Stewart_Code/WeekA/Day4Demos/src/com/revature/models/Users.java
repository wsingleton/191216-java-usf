package com.revature.models;

import java.util.Objects;

public class Users {
    private int Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    public Users() {
        super();
    }

    public Users(String Firstname, String Lastname, String Username, String pw, Role Role){
        this.role = Role;
        this.firstName = Firstname;
        this.lastName = Lastname;
        this.userName = Username;
        this.role = Role;
        this.password = pw;
    }
    public Users(int id,String Firstname, String Lastname, String Username, String pw, Role Role){
        this(Firstname,Lastname,Username,pw,Role);
        this.Id= id;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        //optional validation logic can be included in setters
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
        Users users = (Users) o;
        return Id == users.Id &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(lastName, users.lastName) &&
                Objects.equals(userName, users.userName) &&
                Objects.equals(password, users.password) &&
                role == users.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, userName, password, role);
    }

    @Override
    public String toString() {
        return "Users{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
