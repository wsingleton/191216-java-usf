package com.revature.fauxbankextended.services;

import com.revature.fauxbankextended.repos.AccountRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.fauxbankextended.BankDriver.*;

public class AccountService {

    private AccountRepository acctRepo;

    public AccountService() {

    }

    public AccountService(AccountRepository repo) {
        this.acctRepo = repo;
    }

    public void validateDeposit(String amount) {

        Double balance = app().getCurrentSession().getSessionAccount().getBalance();

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            app().getRouter().navigate("/dashboard");
        }

        Double deposit = Double.valueOf(amount);

        if (deposit < 0 || deposit > 10000) {
            deposit = 0.0;
            System.out.println("Try again!");
            app().getRouter().navigate("/dashboard");
        }
        Double updatedDeposit = convertAmount(deposit);

        balance += updatedDeposit;
        Double bal = convertAmount(balance);
        app().getCurrentSession().getSessionAccount().setBalance(bal);

        acctRepo.update(app().getCurrentSession().getSessionAccount());
    }

    public void validateWithdraw(Double balance, String amount) {

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            app().getRouter().navigate("/dashboard");
        }

        Double withdraw = Double.valueOf(amount);

        if (withdraw > balance || withdraw < 0) {
            withdraw = 0.0;
            System.out.println("Try again!");
            app().getRouter().navigate("/dashboard");
        }
        Double updatedWithdraw = convertAmount(withdraw);

        balance -= updatedWithdraw;
        Double bal = convertAmount(balance);
        app().getCurrentSession().getSessionAccount().setBalance(bal);

        acctRepo.update(app().getCurrentSession().getSessionAccount());
    }

    public Double convertAmount (Double amount) {

        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }
}
