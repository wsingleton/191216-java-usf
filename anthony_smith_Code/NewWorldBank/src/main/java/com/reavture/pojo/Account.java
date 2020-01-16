package com.reavture.pojo;

import java.util.Objects;

public class Account {




    private int accountID;
    private int balance;
    private int user_id;

    public Account(int user_id, int balance) {
        this.user_id = user_id;
        this.balance = balance;


    }

    public Account() {

    }


    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Account account = (Account) o;
//        return Objects.equals(accountID, account.accountID) &&
//                Objects.equals(balance, account.balance) &&
//                Objects.equals(user_id, account.user_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accountID, balance, user_id);
//    }
//
//
//    @Override
//    public String toString() {
//        return "Account{" +
//                "accountID=" + accountID +
//                ", balance=" + balance +
//                ", user_id=" + user_id +
//                '}';
//    }
}


