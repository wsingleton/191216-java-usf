package com.banking.repo;

import java.util.List;

import com.banking.dao.BankAccountsDao;
import com.banking.pojos.Accounts_Bank;

public class BankAccountRepo {

    static BankAccountsDao bankAcc = new BankAccountsDao();

    public List<Accounts_Bank> findAllBankAcc() {

        return bankAcc.findAll();

    }

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