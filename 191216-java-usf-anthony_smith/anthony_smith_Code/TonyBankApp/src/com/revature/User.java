package com.revature;

public class User{


        //Instance Variables
        String firstName;
        String lastName;
        String userName;
        String password;
        Double startingBalance;
        Account account = new Account();

    public Double getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(Double startingBalance) {
        this.startingBalance = startingBalance;
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
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(String firstName, String lastName, String userName, String password, Double startingBalance){

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.startingBalance = this.startingBalance;
    }

    @Override
    public String toString(){
            return firstName + " " + lastName + " " + userName;
    }


}
