package com.bankboi.repos;

import java.util.List;
import com.bankboi.DatabaseLayer.BankData;
import com.bankboi.plainjava.BankAccounts;

    public class bankboirepo {

        static BankData bankAcc = new BankData();

        public List<BankData> findAllBankAcc() {

            return bankAcc.findAll();

        }

        public BankAccounts findAccountBank(int id) {

            return bankAcc.findById(id);

        }

        public BankAccounts saveAccountBank(BankAccounts obj) {

            return bankAcc.save(obj);

        }

        public BankAccounts updateAccountBank(BankAccounts obj) {

            return bankAcc.update(obj);

        }

    }

