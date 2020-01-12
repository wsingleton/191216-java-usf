package com.revature.screens;
import com.revature.repos.AccountRepository;

import static com.revature.BankDriver.*;

public class WithdrawScreen extends Screen {
    public WithdrawScreen(String name, String route) {
        super(name, route);
    }
    @Override
    public void render() {
        System.out.println("Input a withdraw amount");
        System.out.print("> ");
        String withdrawAmount = console.nextLine();
        AccountRepository acct = new AccountRepository();
        acct.decreaseAccountBalance(withdrawAmount);
    }
}
