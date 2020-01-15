package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.AccountService;

import static com.revature.fauxbankextended.BankDriver.*;

public class DepositScreen extends Screen {

    private AccountService accountService;

    public DepositScreen(AccountService accountService) {
        super("DepositScreen", "/deposit");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        Double balance = app().getCurrentSession().getSessionAccount().getBalance();

        System.out.println("\n\n\n\n\n");
        System.out.println("Your Account Balance: $" + balance);
        System.out.println("How much would you like to deposit? (Must be less than 10000)");
        System.out.print("> ");

        try{

            String amount = app().getConsole().readLine();
            accountService.validateDeposit(amount);

        }catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }
        app().getRouter().navigate("/transition");
    }
}
