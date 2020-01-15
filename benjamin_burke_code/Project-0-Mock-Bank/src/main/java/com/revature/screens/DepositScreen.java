package com.revature.screens;

import com.revature.repos.AccountRepository;

import java.io.IOException;

import static com.revature.AppDriver.console;

public class DepositScreen extends Screen {
    public DepositScreen(String name, String route){
        super(name, route);
    }

    @Override
    public void render() throws IOException {
        System.out.println("How much do you want to deposit");
        System.out.println("> ");
        String da = console.readLine();
        AccountRepository acc = new AccountRepository();
        acc.depositAccountBalance(da);

    }
}
