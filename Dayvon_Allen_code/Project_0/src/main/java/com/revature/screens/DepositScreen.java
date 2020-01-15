package com.revature.screens;
import com.revature.exceptions.InvalidRequestException;
import com.revature.services.AccountService;

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
        AccountService acct = new AccountService();
        try {
            acct.deposit(depositAmount);

        } catch (InvalidRequestException e) {
            System.out.println("------------------------------");
            System.out.println("Must only use digits(no more than two numbers after a decimal)");
            System.out.println("------------------------------\n");
            router.navigate("/customer");
        }
    }
}
