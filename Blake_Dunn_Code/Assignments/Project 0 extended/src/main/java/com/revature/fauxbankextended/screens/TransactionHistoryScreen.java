package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.*;

public class TransactionHistoryScreen extends Screen {

    private UserService userService;

    public TransactionHistoryScreen(UserService uService) {
        super("TransactionHistoryScreen", "/history");
        this.userService = uService;
    }

    @Override
    public void render() {

        System.out.println("\n+-------  View Transaction History  ------- +\n");
        System.out.println("1) View all your transactions");
        System.out.println("2) View current account transactions");

        try {
            System.out.print("> ");
            String input = app().getConsole().readLine();

            switch(input) {
                case "1":
                    printTransactionHistory();
                    userService.viewCurrentUserTransactionHistory();
                    break;
                case "2":
                    printTransactionHistory();
                    userService.viewCurrentAcctTransactionHistory();
                    break;
                default:
                    System.out.println("Invalid selection");
                    app().getRouter().navigate("/dashboard");
            }

        }catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

        app().getRouter().navigate("/transition");
    }

    public void printTransactionHistory () {

        System.out.println("\n\n");
        System.out.println("+-------  Transaction History  ------- +\n\n");
        System.out.println("   User ID          Account ID        Transaction Type           Transaction Amount              Transaction Date");

    }
}
