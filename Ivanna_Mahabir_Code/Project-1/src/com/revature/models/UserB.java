package com.revature.models;

import java.util.InputMismatchException;
import java.util.Objects;

public class UserB {
    private int id; // use to link accts?? acctId - generated automatically
    private String username; //unique, b/t 5 to 20 char ??
    private String password; // same length
    private double balance; //initial set to 0.

    //private int type; // sv#-saving, ch#-checking, multi accts??


    public UserB() {
    }

    public UserB(int id, String username, String password, double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    //unique username //
    public void setUsername(String username) {
        try {
            if (validate(username) == true) {
                this.username = username;
            } else {
                System.out.println(username + " Invalid");
                //System.exit(0);
            }
        }
        catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        try {
            if (validate(password) == true) {
                this.password = password;
            } else {
                System.out.println(password + " Invalid");
                System.exit(0);
            }
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
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
        return id + ":" + username + ":" + password + ":" + balance;
    }

    public static boolean uCase(char ch){
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
    public static boolean nCase(char ch){
        return (ch >= '0' && ch <=9);
    }

   //Validation for new entry
    public boolean validate(String arg) {
        if (arg.length() >= 8 && arg.length() <= 15) {
            for (int i = 0; i < arg.length(); i++) {
                char ch = arg.charAt(i);
                if (uCase(ch)) {
                    if (nCase(ch))
                        return true;
                    //break;
                }
            }
        }
        return false;
    }

    //validation for login of previous
    public boolean comparison(String uArg, String pArg) {
        if (uArg.equals(getUsername()) && pArg.equals(getPassword())){
            System.out.println("Welcome " + getUsername());
            System.out.println("Your current available balance: " + balance);
        //if username && pass are true
    }
            return false;
    }

    public double withdraw(double amt){
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserB userB = (UserB) o;
        return id == userB.id &&
                Double.compare(userB.balance, balance) == 0 &&
                Objects.equals(username, userB.username) &&
                Objects.equals(password, userB.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, balance);
    }

    @Override
    public String toString() {
        return "UserB{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
