package models;

import java.util.Objects;

public class Account {
    private int acctNum;
    private int acctOwner;
    private double acctBalance;
    private AccountType acctType;
    public Account(int acctNum, int acctOwner, double acctBalance, AccountType acctType) {
        this.acctNum = acctNum;
        this.acctOwner = acctOwner;
        this.acctBalance = acctBalance;
        this.acctType = acctType;
    }
    public int getAcctNum() {
        return acctNum;
    }
    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }
    public int getAcctOwner() {
        return acctOwner;
    }
    public void setAcctOwner(int acctOwner) {
        this.acctOwner = acctOwner;
    }
    public double getAcctBalance() {
        return acctBalance;
    }
    public void setAcctBalance(double acctBalance) {
        this.acctBalance = acctBalance;
    }
    public AccountType getAcctType() {
        return acctType;
    }
    public void setAcctType(AccountType acctType) {
        this.acctType = acctType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return acctNum == account.acctNum &&
                acctOwner == account.acctOwner &&
                Double.compare(account.acctBalance, acctBalance) == 0 &&
                acctType == account.acctType;
    }
    @Override
    public int hashCode() {
        return Objects.hash(acctNum, acctOwner, acctBalance, acctType);
    }
    @Override
    public String toString() {
        return "Account{" +
                "acctNum=" + acctNum +
                ", acctOwner=" + acctOwner +
                ", acctBalance=" + acctBalance +
                ", acctType=" + acctType +
                '}';
    }
}
