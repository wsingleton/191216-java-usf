package com.revature.fauxbank.services;

import com.revature.fauxbank.exceptions.InvalidAmountException;
import com.revature.fauxbank.repos.AccountRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.fauxbank.BankDriver.*;

public class AccountService {

    private AccountRepository acctRepo;

    public AccountService() {

    }

    public AccountService(AccountRepository repo) {
        this.acctRepo = repo;
    }

    public Double validateDeposit(String amount) {

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            return 0.0;
        }

        Double deposit = Double.valueOf(amount);

        if (deposit < 0 || deposit > 10000) {
            System.out.println("Try again!");
            return 0.0;
        }

        return convertAmount(deposit);
    }

    public Double validateWithdraw(String amount) {

        if (amount == null || amount.equals("") || amount.matches("^[a-zA-Z]*$")) {
            System.out.println("Try again!");
            return 0.0;
        }

        Double withdraw = Double.valueOf(amount);

        if (withdraw > currentAccount.getBalance() || withdraw < 0) {
            System.out.println("Try again!");
            return 0.0;
        }
        return convertAmount(withdraw);
    }

    public Double convertAmount (Double amount) {

        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }
}
