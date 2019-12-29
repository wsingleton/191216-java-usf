package com.revature;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    public User(){
        super();
    }
    public User(String fn, String ln, String userName, String password){
        // super() ; // a call to the super class,s constructor is implicitly here id it mot provided
        firstName = fn; // this is not require if no parameters match the field name
        this.lastName=ln;//you can still include it though
        this.userName = userName;// here we must use "this" to clarity which one we are refering
        this.password = password;


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String useName) {
        this.userName = useName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash( firstName, lastName, userName, password);
    }

    @Override
    public String toString() {
        return "User{" +  " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", useName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
