package com.revature.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AccountUser {

    private User customer;
    private Set<Account> accountUser;

    public AccountUser(){
        super();
        accountUser = new HashSet<>();

    }

    public AccountUser(User customer, Set<Account> accountUser) {
        this.customer = customer;
        this.accountUser = accountUser;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Set<Account> getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(Set<Account> accountUser) {
        this.accountUser = accountUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUser that = (AccountUser) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(accountUser, that.accountUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, accountUser);
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "customer=" + customer +
                ", accountUser=" + accountUser +
                '}';
    }
}
