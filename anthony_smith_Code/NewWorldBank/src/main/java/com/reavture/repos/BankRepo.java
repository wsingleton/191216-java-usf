package com.reavture.repos;

import java.util.List;

import com.reavture.dao.*;
import com.reavture.pojo.*;

public class BankRepo {

    static AccountsDao bankAcc = new AccountsDao();

    public List<Account> findAllBankAcc(){
        return bankAcc.findAll();
    }

    public Account findAccountBank(int id){
        System.out.println("REPOCHECK");
        return bankAcc.findById(id);
    }

    public Account saveAccountBank(Account obj){
        return bankAcc.save(obj);
    }

    public Account updateAccountBank(Account obj){
        return bankAcc.update(obj);
    }
}
