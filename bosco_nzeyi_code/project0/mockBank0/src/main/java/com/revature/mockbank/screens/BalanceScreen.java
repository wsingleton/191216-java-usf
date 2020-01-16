package com.revature.mockbank.screens;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.exceptions.ResourcePersistenceException;
import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.AccountAccess;
import com.revature.mockbank.models.AccountType;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.services.AccountService;

import java.sql.SQLOutput;

import static com.revature.mockbank.AppDriver.*;
import static com.revature.mockbank.AppDriver.appRunning;

public class BalanceScreen extends Screen {


    private AccountService accountService;

    public BalanceScreen(AccountService accountService) {
        super("BalanceScreen", "/balance");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        try {

            int accountNumber = currentAccount.getAccount_id();
            double balance = currentAccount.getBalance();

            System.out.println("\n------------------------------------------------");

            System.out.println("ACCOUNT NUMBER = " + accountNumber);
            System.out.println("BALANCE=         $" + balance);
            System.out.println("------------------------------------------------\n");

            router.navigate("/dashboard");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            //appRunning = false;
        }

    }
}
