package com.revature.screens;

import com.revature.repos.AccountRepository;

import java.io.IOException;

import static com.revature.AppDriver.console;

public class WithdrawScreen extends Screen {

    public WithdrawScreen(String name, String route){
        super("withdrawScreen", "/withdraw");
    }

    @Override
    public void render() throws IOException {
        System.out.println("How much do you want to withdraw?");
        System.out.println("> ");
        String wa = console.readLine();
        AccountRepository acc = new AccountRepository();
        acc.withdrawAccountBalance(wa);

    }
}
