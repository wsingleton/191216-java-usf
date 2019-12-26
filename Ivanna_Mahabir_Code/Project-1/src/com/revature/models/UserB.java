package com.revature.models;

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
        this.balance = balance;
    }

    public String toFileString(){
        return id + ":" + username + ":" + password + ":" + balance;
    }

  /*  public void validateUser(String u){
        //test length of username. must be b/t 5 - 15 chara 
        //u = getUsername();
        if (u.length() > 4 || u.length() < 16){
            System.out.println("Correct length of username");
            setUsername(u);
            this.username = u;
        }
        else{
            System.out.println("Invalid entry");
        }
    }*/

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
