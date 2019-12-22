package com.revature.models;

import java.util.Objects;
import java.util.Scanner;
import java.util.*;
import static java.lang.Math.abs;

public class Users {
    private int Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

    //establish default user object
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



    //create User object (firstname, lastname, username) updated with the password variable
    public Users(Users myfirstname, Users mylastname, Users myusername, String mypw){
        this.firstName = myfirstname.firstName;
        this.lastName = mylastname.lastName;
        this.userName = myusername.userName;
        this.password = mypw;
    }


    public Users(String username){
        this.userName = username;
    }


    //create User object( firstname, lastname, ) updated with the username variable
    public Users(Users myfirstname, Users mylastname ,String username){
        this.firstName = myfirstname.firstName;
        this.lastName = mylastname.lastName;
        this.userName = username;
    }
    public static int generateId(){

        int x = (int)(Math.random()*((99999999-0)+1))+0;
            return x;

    }


    //create User object updated with  lastname variable
    public Users(Users mylastname,String lastname){
        this.lastName = mylastname.lastName;
        this.lastName = lastname;
    }
    public Users(int id,String Firstname, String Lastname, String Username, String pw, Role Role){
        this(Firstname,Lastname,Username,pw,Role);
        this.Id= id;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
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
