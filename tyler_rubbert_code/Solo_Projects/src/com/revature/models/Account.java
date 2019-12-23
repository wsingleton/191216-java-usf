package com.revature.models;

import java.util.Objects;

public class Account {
    private int id;
    private String type;
    private int amount;

    public Account() {
        super();
    }

    public Account(int id, String type, int amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                amount == account.amount &&
                Objects.equals(type, account.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }

}
