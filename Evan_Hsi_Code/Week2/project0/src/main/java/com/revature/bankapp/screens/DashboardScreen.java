package com.revature.bankapp.screens;

import com.revature.bankapp.BankDriver;
import com.revature.bankapp.repositories.AccountRepository;
import com.revature.bankapp.services.AccountService;

import java.io.IOException;

import static com.revature.bankapp.BankDriver.*;

public class DashboardScreen extends Screen {
    private AccountService accountService;

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public DashboardScreen(AccountService accountService) {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome " + currentUser.getFirstName()
                + " " + currentUser.getLastName() + "!");
        //System.out.println(BankDriver.currentUser);
        boolean run = true;

        while(run) {

            System.out.print("1) View Accounts\n" +
                    "2) Manage Accounts\n" +
                    "3) View Transactions\n" +
                    "4) Exit\n" +
                    "---------------\n" +
                    "> ");

            try {
                String userChoice = console.readLine();
                switch (userChoice) {
                    case "1":
                        System.out.println(accountService.findAllByUser(userid));
                        break;
                    case "2":
                        router.navigate("/accountscreen");
                        break;
                    case "3":
                        router.navigate("/transaction");
                        break;
                    case "4":
                        run = false;
                        appRunning = false;
                        break;
                    default:
                        System.out.println("[LOG] - Invalid selection!");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] - " + e.getMessage());
                //System.out.println("[LOG] - Shutting down application");
                appRunning = false;
            }
        }

    }
}
