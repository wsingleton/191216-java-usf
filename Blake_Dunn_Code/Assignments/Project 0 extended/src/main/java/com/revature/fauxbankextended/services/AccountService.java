package com.revature.fauxbankextended.services;

import com.revature.fauxbankextended.models.Transaction;
import com.revature.fauxbankextended.models.TransactionType;
import com.revature.fauxbankextended.repos.AccountRepository;
import com.revature.fauxbankextended.repos.TransactionRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.fauxbankextended.BankDriver.*;

public class AccountService {

    private AccountRepository acctRepo;
    private TransactionRepository transRepo;

    public AccountService(AccountRepository repo, TransactionRepository transRepo) {
        this.acctRepo = repo;
        this.transRepo = transRepo;
    }

    public boolean validateDeposit(String amount) {

        Double balance = app().getCurrentSession().getSessionAccount().getBalance();

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            return false;
        }

        Double deposit = Double.valueOf(amount);

        if (deposit < 0 || deposit > 10000) {
            deposit = 0.0;
            System.out.println("Try again!");
            return false;
        }
        Double updatedDeposit = convertAmount(deposit);

        balance += updatedDeposit;
        Double bal = convertAmount(balance);
        app().getCurrentSession().getSessionAccount().setBalance(bal);
        acctRepo.update(app().getCurrentSession().getSessionAccount());
        Transaction newTransaction = new Transaction(app().getCurrentSession().getSessionUser().getId(),
                app().getCurrentSession().getSessionAccount().getId(), updatedDeposit, TransactionType.DEPOSIT);
        transRepo.save(newTransaction);

        return true;
    }

    public boolean validateWithdraw(Double balance, String amount) {

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            return false;
        }

        Double withdraw = Double.valueOf(amount);

        if (withdraw > balance || withdraw < 0) {
            withdraw = 0.0;
            System.out.println("Try again!");
            return false;
        }
        Double updatedWithdraw = convertAmount(withdraw);

        balance -= updatedWithdraw;
        Double bal = convertAmount(balance);
        app().getCurrentSession().getSessionAccount().setBalance(bal);
        acctRepo.update(app().getCurrentSession().getSessionAccount());
        Transaction newTransaction = new Transaction(app().getCurrentSession().getSessionUser().getId(),
                app().getCurrentSession().getSessionAccount().getId(), updatedWithdraw, TransactionType.WITHDRAW);
        transRepo.save(newTransaction);

        return true;
    }

    public Double convertAmount (Double amount) {

        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }
}
