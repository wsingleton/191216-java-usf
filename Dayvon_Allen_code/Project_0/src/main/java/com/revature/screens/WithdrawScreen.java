package com.revature.screens;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;

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
        AccountService acct = new AccountService();
        try {
            acct.withdraw(withdrawAmount);
        } catch (ResourcePersistentException e) {
            System.out.println("------------------------------");
            System.out.println("Insufficient funds!");
            System.out.println("------------------------------\n");
            router.navigate("/customer");
        } catch (InvalidRequestException e) {
            System.out.println("------------------------------");
            System.out.println("Must only use digits(no more than two numbers after a decimal)");
            System.out.println("------------------------------\n");
            router.navigate("/customer");
        }


    }
}
