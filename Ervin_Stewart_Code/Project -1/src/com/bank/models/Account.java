package com.bank.models;

public class Account {
    private int Id;
    private long balance;
    private  long ownerId;
    //private  Type type;

    public Account() {
        super();
    }

    public Account(int ID, long Balance, long ownerID){
        this.Id = ID;
        this.balance = Balance;
        this.ownerId = ownerID;

    }

}
