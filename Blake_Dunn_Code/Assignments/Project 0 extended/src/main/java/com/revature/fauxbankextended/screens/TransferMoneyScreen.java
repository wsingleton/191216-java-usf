package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.AccountService;

import static com.revature.fauxbankextended.BankDriver.app;

public class TransferMoneyScreen extends Screen {

    private AccountService accountService;

    public TransferMoneyScreen(AccountService accountService) {
        super("TransferMoneyScreen", "/transfer");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        System.out.println("Welcome to the transfer screen.");

        if(accountService.transferMoney()) {
            System.out.println("Your transfer was a success!");
        }
        else {
            System.out.println("Sorry, we could not complete our transfer.");
        }

        app().getRouter().navigate("/dashboard");



    }
}
