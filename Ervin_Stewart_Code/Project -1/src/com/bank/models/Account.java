package com.bank.models;

import java.util.Objects;

public class Account {
    private int Id;
    private double balance;
    //private long ownerId;
    //private  Type type;

    public Account(){super();}

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", balance=" + balance +
                '}';
    }

    public Account(int id, double balance){
        this.Id= id;
        this.balance = balance;

    }

//    public Account(int ID, double Balance, long ownerID){
//        this(ID,Balance);
//        this.ownerId = ownerID;
//
//    }

  public int getAccountId() {
        return Id;
    }

   public void setAccountId(int id) {
        this.Id = id;
    }

    public double getBalance() {
        return balance;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public long getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(long ownerId) {
//        this.ownerId = ownerId;
//    }

    public String toFileString(){return Id + ":" + balance; }
}
