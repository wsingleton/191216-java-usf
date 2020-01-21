package com.revature.models;

import java.util.Objects;

public class UserAccount {
    private Integer userId;
    private Integer accountNumber;

    public UserAccount(){
        super();
    }

    public UserAccount(Integer userId, Integer accountNumber) {
        this.userId = userId;
        this.accountNumber = accountNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountNumber);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
