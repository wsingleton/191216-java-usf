package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.AccountService;

import static com.revature.fauxbankextended.BankDriver.*;

public class WithdrawScreen extends Screen {

    private AccountService accountService;


    public WithdrawScreen(AccountService accountService) {
        super("WithdrawScreen", "/withdraw");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        Double balance = app().getCurrentSession().getSessionAccount().getBalance();

        System.out.println("\n\n\n");
        System.out.println("+-------  Withdraw  ------- +\n");
        System.out.println("Your Account Balance: $" + balance);
        System.out.println("Enter Withdraw Amount");
        System.out.print("> ");

        try{
            String amount = app().getConsole().readLine();
            accountService.validateWithdraw(balance, amount);

        }catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

        app().getRouter().navigate("/transition");
    }
}
