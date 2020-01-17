package com.bankboi.repos;

import com.bankboi.DatabaseLayer.BankData;
import com.bankboi.plainjava.BankAccounts;

import java.util.List;

    public class bankboirepo {

        static BankData bankAcc = new BankData();

        public List<BankAccounts> findAllBankAcc() {

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

