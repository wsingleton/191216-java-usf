package com.revature.repo;

import java.util.List;

import com.revature.dao.BankAccountsDao;
import com.revature.pojos.Accounts_Bank;

public class BankAccountRepo {

    static BankAccountsDao bankAcc = new BankAccountsDao();


    public Accounts_Bank findAccountBank(int id) {

        return bankAcc.findById(id);

    }

    public Accounts_Bank saveAccountBank(Accounts_Bank obj) {

        return bankAcc.save(obj);

    }

    public Accounts_Bank updateAccountBank(Accounts_Bank obj) {

        return bankAcc.update(obj);

    }

}