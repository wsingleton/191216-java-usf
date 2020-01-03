package com.company;

public class Services {

    private double balance;

    public Services()
    {
        balance = 0;
    }

    public Services(double amount)
    {
        balance = amount;
    }

    public void deposit(double amount)
    {
        balance=balance+amount;
    }

    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    public double getBalance()
    {
        return balance;
    }

    public void close()
    {
        balance = 0;
    }

}
