package com.revature.models;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserB {
    private String username; //unique, b/t 5 to 20 char ??
    private String password; // same length
    private double balance; //initial set to 0.

    //private int type; // sv#-saving, ch#-checking, multi accts??


    public UserB() {
    }

    public UserB( String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    //unique username //
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        try{
        if(balance <= 0){
            System.out.println(balance + " Insufficient funds");}
        else{
            this.balance = balance;
        }}
        catch(InputMismatchException e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }

    }

    public String toFileString(){
        return username + ":" + password + ":" + balance;
    }

    public static boolean uCase(char ch){
        ch = Character.toUpperCase(ch);
        return ch >= 'A' && ch <= 'Z';
    }
    public static boolean nCase(String passwor){
        return Pattern.compile("[0-9]").matcher(passwor).find();
    }

   //Validation for new entry

    public static boolean validate(String arg) {
        if (arg.length() >= 8 && arg.length() <= 15) {
            System.out.println("length acceptable");
            for (int i = 0; i < arg.length(); i++) {
                char ch = arg.charAt(i);
                if (uCase(ch)) {
                    System.out.println("corrct char");
                    if (nCase(arg)) {
                        System.out.println("correct num"); // test
                        return true;
                    }
                    //break;
                }
            }
        }
        System.out.println("Invalid Input");
        return false;
    }

/*    public double withdraw(double amt){
        if (amt <= balance) {
            return balance - amt;
        }
        else{
            System.out.println("Invalid Withdrawl amount");
            return balance;
        }
    }

    public double deposit(double amt){
        if (amt >= 0) {
            return balance + amt;
        }
        else{
            System.out.println("Invalid Deposit amount");
            return balance;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserB userB = (UserB) o;
        return Double.compare(userB.balance, balance) == 0 &&
                Objects.equals(username, userB.username) &&
                Objects.equals(password, userB.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, balance);
    }

    @Override
    public String toString() {
        return "UserB{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}// end of UserB class
