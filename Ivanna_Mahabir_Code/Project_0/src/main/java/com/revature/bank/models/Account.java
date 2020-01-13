package com.revature.bank.models;

import java.util.Objects;

public class Account {
    private Integer acctId;
    private Double deposit;

    public Account(){
        super();
    }

    public Account(Integer acctId, Double deposit) {
        this.acctId = acctId;
        this.deposit = deposit;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(acctId, account.acctId) &&
                Objects.equals(deposit, account.deposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctId, deposit);
    }

    @Override
    public String toString() {
        return "Account{" +
                "acctId=" + acctId +
                ", deposit=" + deposit +
                '}';
    }
}
