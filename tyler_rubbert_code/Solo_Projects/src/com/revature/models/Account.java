package com.revature.models;

import java.util.Objects;

public class Account {
    private User user;
    private double amount;

    public Account() {
        super();
    }

    public Account(User user, int amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getId() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    // method to deposit
    public void deposit(double depAmount) {
        this.amount = amount + depAmount;
    }

    // method to withdraw
    public void withdraw(double withAmount) {
        this.amount = amount - withAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return user == account.user &&
                amount == account.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", amount=" + amount +
                '}';
    }


}
