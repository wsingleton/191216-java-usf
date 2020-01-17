package com.revature.repo;

import com.revature.dao.BankAccountsDao;
import com.revature.pojos.User;

public class BankAccountRepo {

    static BankAccountsDao bankAcc = new BankAccountsDao();

    public User.Accounts_Bank findAccountBank(int id) {

        return bankAcc.findById(id);

    }

    public User.Accounts_Bank saveAccountBank(User.Accounts_Bank obj) {

        return bankAcc.save(obj);

    }

    public User.Accounts_Bank updateAccountBank(User.Accounts_Bank obj) {

        return bankAcc.update(obj);

    }

}