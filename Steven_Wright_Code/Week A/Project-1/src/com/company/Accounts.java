package com.company;

import java.util.Objects;

public class Accounts {

    private Double balance;

   private String username;

    public Accounts(Double balance, String username) {
        this.balance = balance;
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(balance, accounts.balance) &&
                Objects.equals(username, accounts.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, username);
    }

    @Override
    public String toString() {
        return balance + "," + username +";\n";
    }


}
