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

        if (amount == null || amount.equals("")) {
            throw new InvalidAmountException();
        }

        Double deposit = Double.valueOf(amount);

        if (deposit < 0 || deposit > 10000) {
            System.out.println("Try again!");
//            router.navigate("/dashboard");
        }
        return deposit = validateAmount(deposit);
    }

    public Double validateWithdraw(String amount) {

        if (amount == null || amount.equals("")) {
            throw new InvalidAmountException();
        }

        Double withdraw = Double.valueOf(amount);

        if (withdraw > currentAccount.getBalance() || withdraw < 0) {
            System.out.println("Try again!");
            router.navigate("/dashboard");
        }
        return withdraw = validateAmount(withdraw);
    }

    public Double validateAmount (Double amount) {

        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }

    public void newTransaction() {

        System.out.println("Would you like to perform another transaction?");
        System.out.println("1) Yes");
        System.out.println("2) Logout");
        System.out.println("3) Exit Application");

        try {
            System.out.print("> ");
            String input = console.readLine();

            switch (input) {

                case "1":
                    router.navigate("/dashboard");
                    break;
                case "2":
                    router.navigate("/home");
                    break;
                case "3":
                    System.out.println("Exiting application...");
                    appRunning = false;
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection");
                    router.navigate("/home");
            }

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }
    }

}
