package com.revature;

public class Account {

    private String userName;
    private double balance ;

    public Account(){
        super();
    }
    public Account(String userName, double balance){
        this.balance = balance;
        this.userName= userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User Name=" + userName + ", balance=" + balance + "]";
    }

    public String saveString(){
        return userName + ":" + balance;
    }


}
