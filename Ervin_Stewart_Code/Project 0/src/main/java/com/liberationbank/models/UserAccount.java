package com.liberationbank.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserAccount {
    private User owner;
    private Set<Account> userAccount;

    public UserAccount(){
        super();
        userAccount= new HashSet<>();
    }

    public UserAccount(User owner, Set<Account> userAccount) {
        this.owner = owner;
        this.userAccount = userAccount;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Account> getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Set<Account> userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(owner, that.owner) &&
                Objects.equals(userAccount, that.userAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, userAccount);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "owner=" + owner +
                ", userAccount=" + userAccount +
                '}';
    }
}
