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

        System.out.print("User ID          Account ID          Transaction          Transaction Amount          Transaction Date");
        userService.viewCurrentAcctTransactionHistory();

        app().getRouter().navigate("/transition");

    }
}
