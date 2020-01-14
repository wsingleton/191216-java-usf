package com.revature.fauxbankextended.screens;

import static com.revature.fauxbankextended.BankDriver.app;

public class TransferMoneyScreen extends Screen {

    public TransferMoneyScreen() {
        super("TransferMoneyScreen", "/transfer");
    }

    @Override
    public void render() {

        System.out.println("Welcome to the transfer screen.");
        System.out.println("How much would you like to transfer from " + app().getCurrentSession().getSessionAccount().getAccountType() + "?");



    }
}
