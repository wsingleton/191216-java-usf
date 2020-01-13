package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.AccountService;

import static com.revature.fauxbankextended.BankDriver.*;

public class BalanceScreen extends Screen {

    private AccountService accountService;

    public BalanceScreen(AccountService accountService) {
        super("BalanceScreen", "/balance");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        Double balance = app().getCurrentSession().getSessionAccount().getBalance();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("");
        System.out.println("Your Balance: $" + balance);

        app().getRouter().navigate("/transition");

    }
}
