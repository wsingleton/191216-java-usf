package com.revature.models;

import com.revature.repositories.AccountRepository;

import java.io.*;

import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.*;


public class Account {
    private Integer accountNo, id;
    private Double accountAmount;// need to ensure precision to two decimal places
    private AccountType accountType;


    Random random = new Random();

    public Account(Integer id, AccountType type){
        this.id = id;
        this.accountType = type;
    }

    public Account(Integer accountNo, Integer id, Double accountAmount, AccountType accountType) {
        this.accountNo = accountNo;
        this.id = id;
        this.accountAmount = accountAmount;
        this.accountType = accountType;
    }

    public Account(Integer id){
        AccountRepository ar = new AccountRepository();
        this.id = id;
        this.accountNo = getAccountNo();
        this.accountAmount = getAccountAmount(id);
    }

    public Account(Integer id, Double accountAmount, AccountType type){
        this.id = id;
        this.accountAmount = accountAmount;
        this.accountNo = random.nextInt();
        this.accountType = type;
    }
    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo){
        this.accountNo = accountNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAccAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Double accountAmount) {
        this.accountAmount = accountAmount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String toFileString(){
       String fileString = id + "," + accountNo + "," + accountAmount + "," + accountType;
       return fileString;
    }

    public Account createAccount(Integer id, Double accountAmount, AccountType type){
        return new Account(id, accountAmount, type);
    }

    public Double getAccountAmount(Account account){
        DecimalFormat df = new DecimalFormat("#.##");

        return null;
    }

    public static Double getAccountAmount(Integer id){
        DecimalFormat df = new DecimalFormat("#.##");

        return 0.0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.accountAmount, accountAmount) == 0 &&
                accountNo.equals(account.accountNo) &&
                id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo, id, accountAmount);
    }

    @Override
    public String toString() {
        return accountNo.toString();
    }


}
