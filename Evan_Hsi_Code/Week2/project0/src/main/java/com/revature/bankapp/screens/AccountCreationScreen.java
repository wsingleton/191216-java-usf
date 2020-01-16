package com.revature.bankapp.screens;

import com.revature.bankapp.models.Type;
import com.revature.bankapp.services.AccountService;

import static com.revature.bankapp.BankDriver.*;
import static com.revature.bankapp.BankDriver.appRunning;

public class AccountCreationScreen extends Screen {

    private AccountService accountService;

    public AccountCreationScreen() {
        super("AccountCreationScreen", "/accountcreation");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public AccountCreationScreen(AccountService accountService) {
        super("AccountCreationScreen", "/accountcreation");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render() {

        boolean run = true;
        while(run) {
            System.out.println("Select type of account you want to make");
            System.out.print("1) Create Checking\n" +
                    "2) Create Savings\n" +
                    "3) Back\n" +
                    "----------------\n" +
                    "> ");

            String userChoice = "";
            try {
                userChoice = console.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            switch(userChoice) {
                case "1":
                    accountService.createAccount(Type.CHECKING);
                    router.navigate("/accountscreen");
                    break;
                case "2":
                    accountService.createAccount(Type.SAVINGS);
                    router.navigate("/accountscreen");
                case "3":
                    appRunning = false;
                    run = false;
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");
            }
        }

    }
}
