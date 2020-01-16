package com.revature.screens;

import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;

import java.io.IOException;

import static com.revature.AppDriver.console;


public class DepositScreen extends Screen {

    private AccountService accountService;

    public DepositScreen(String name, String route){
        super(name, route);
        this.accountService = accountService;
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
