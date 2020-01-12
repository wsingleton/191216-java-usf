package com.revature.screens;
import com.revature.repos.AccountRepository;

import static com.revature.BankDriver.*;

public class DepositScreen extends Screen {
    public DepositScreen(String name, String route) {
        super(name, route);
    }

    @Override
    public void render() {
        System.out.println("Input a deposit amount");
        System.out.print("> ");
        String depositAmount = console.nextLine();
        AccountRepository acct = new AccountRepository();
        acct.increaseAccountBalance(depositAmount);
    }
}
