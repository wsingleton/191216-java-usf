package com.revature.fauxbank.screens;

import com.revature.fauxbank.services.AccountService;

import static com.revature.fauxbank.BankDriver.*;
import static com.revature.fauxbank.BankDriver.router;

public class BalanceScreen extends Screen {

    private AccountService accountService;

    public BalanceScreen(AccountService accountService) {
        super("BalanceScreen", "/balance");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        Double balance = currentAccount.getBalance();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("");
        System.out.println("Your Balance: $" + balance);

        router.navigate("/transition");

    }
}
