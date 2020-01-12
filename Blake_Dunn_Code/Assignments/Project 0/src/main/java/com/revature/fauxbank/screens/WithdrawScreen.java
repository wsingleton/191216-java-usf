package com.revature.fauxbank.screens;

import com.revature.fauxbank.services.AccountService;

import static com.revature.fauxbank.BankDriver.*;

public class WithdrawScreen extends Screen {

    private AccountService accountService;


    public WithdrawScreen(AccountService accountService) {
        super("WithdrawScreen", "/withdraw");
        this.accountService = accountService;
    }

    @Override
    public void render() {

        Double balance = currentAccount.getBalance();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Your Account Balance: $" + balance);
        System.out.println("How much would you like to withdraw?");
        System.out.print("> ");

        try{
            String amount = console.readLine();
            accountService.validateWithdraw(balance, amount);

        }catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

        router.navigate("/transition");

    }
}
