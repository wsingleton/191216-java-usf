package com.bank.models;

public class Account {
    private static int Id;
    private static double balance;
    private static long ownerId;
    //private  Type type;

    public Account() {
        super();
    }

    public Account(int ID, long Balance, long ownerID){
        this.Id = ID;
        this.balance = Balance;
        this.ownerId = ownerID;

    }

    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        balance = balance;
    }

    public static long getOwnerId() {
        return ownerId;
    }

    public static void setOwnerId(long ownerId) {
        ownerId = ownerId;
    }
}
