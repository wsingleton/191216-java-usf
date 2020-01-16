package com.revature.bankapp.screens;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.Transaction;
import com.revature.bankapp.services.AccountService;
import com.revature.bankapp.services.TransactionService;

import java.io.IOException;

import static com.revature.bankapp.BankDriver.*;

public class TransactionScreen extends Screen {

    private TransactionService transactionService;
    private AccountService accountService;

    public TransactionScreen() {
        super("TransactionScreen", "/transaction");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public TransactionScreen(TransactionService transactionService, AccountService accountService) {
        super("TransactionScreen", "/transaction");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.transactionService = transactionService;
        this.accountService = accountService;
    }
    @Override
    public void render() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        boolean run = true;

        while(run) {

            System.out.print("1) View Accounts\n" +
                    "2) View All Transactions\n" +
                    "3) View Transactions by ID\n" +
                    "4) Back\n" +
                    "> ");
            String userChoice = "";
            try {
                userChoice = console.readLine();
            } catch (IOException e) {e.printStackTrace();}

            switch(userChoice) {
                case "1":
                    System.out.println(accountService.findAllByUser(userid));
                    break;
                case "2":
                    System.out.println(transactionService.findAll());
                    break;
                case "3":
                    System.out.println("Input ID of Account");
                    String ids = "";
                    try {
                        ids = console.readLine();
                    } catch (IOException e) { e.printStackTrace(); }
                    int id = Integer.parseInt(ids);
                    if(accountService.owner(id))
                        System.out.println(transactionService.findByID(id));
                    else System.out.println("You do not own this account");
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");

            }
        }
    }
}
