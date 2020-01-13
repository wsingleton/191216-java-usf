package com.revature.bankapp.screens;

import com.revature.bankapp.BankDriver;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

        System.out.println("Made it to Dashboard!");
        System.out.println(BankDriver.currentUser);

    }
}
