package com.revature;

import java.util.HashMap;

public class User{


    String userName;
    String password;
    Double accountBalance;


    public User(String userName, String password, double accountBalance){

        this.userName = userName;
        this.password = password;
        this.accountBalance = accountBalance;
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

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String accountSerialize() {return userName + " " + password + " " + accountBalance;}
     }
