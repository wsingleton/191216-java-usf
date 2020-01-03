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
        if(balance < 0){
            System.out.println("Balance: " + balance + " is invalid");
            System.out.println("Setting Initial Balance to 0");
            setBalance(0);
        }
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

    //test for a Capital Letter
    public static boolean uCase(char ch){
        ch = Character.toUpperCase(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    //test for a number
    public static boolean nCase(String passwor){
        return Pattern.compile("[0-9]").matcher(passwor).find();
    }

   //Validation for username and password
    public static boolean validate(String arg) {
        if (arg.length() >= 8 && arg.length() <= 15) {
            for (int i = 0; i < arg.length(); i++) {
                char ch = arg.charAt(i);
                if (uCase(ch)) {
                    if (nCase(arg)) {
                        return true;
                    }
                    //break;
                }
            }
        }
        System.out.println("Invalid Input");
        return false;
    }

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
