package com.company;

import java.util.Objects;

public class User {

    private String password;
    private String username;
    private String firstName;
    private String lastName;


    public User(String password, String username, String firstName, String lastName) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(password, user.password) &&
                Objects.equals(username, user.username) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username, firstName, lastName );
    }

    @Override
    public String toString() {
        return  password +  "," + username + "," + firstName + "," + lastName + ";";

    }
/*
    public User(String first, String last)
    {
        Map <String, User> users= new Hashmap<String, User>();


        condition = isValid(password);
        while (!password.equals(confirm) && (!condition)) {
            System.out.println("The password is invalid");
            System.out.print("Please enter the password again : ");
            String Password = in.nextLine();
            System.out.print("Please re-enter the password to confirm : ");
            String Confirm = in.nextLine();
            password = Password;
            confirm = Confirm;
            condition = isValid(password);
        }
    }*/
}
