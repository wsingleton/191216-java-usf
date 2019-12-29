package com.revature;

public class BankAccount {
    private String username;
    private String password;
    private double deposit;
    private double withdrawal;
    private double balance;
    private double savingBalance;

    public BankAccount() {

    }
//    public  void main(String... args) {
//        balance = 250.00;
//        deposit = 100.00;
//        deposits(deposit,balance);
//    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(String username, String password, double deposit, double withdrawal, double balance) {
        this.username = username;
        this.password = password;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.balance = balance;
    }

    public BankAccount(double balance, double deposit){
        this.balance = balance;
        this.deposit = deposit;
        this.withdrawal = 10;
    }

    public BankAccount(String username){
        this.username = username;
    }

    public void deposits(double amount){
        this.balance = this.balance + amount;
        System.out.println("Deposit is successful and new balance available"+this.balance);
    }
    public double withdrawal(double amount){
        if(amount<= this.balance) {
            balance = balance - amount;
        }
        else {
            System.out.println("Transaction is not successful");
        }
         return balance;
    }
}





