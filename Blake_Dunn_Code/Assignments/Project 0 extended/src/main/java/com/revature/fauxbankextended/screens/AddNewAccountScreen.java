package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.*;

public class AddNewAccountScreen extends Screen {

    private UserService userService;

    public AddNewAccountScreen(UserService userService) {
        super("AddNewAccountScreen", "/addacct");
        this.userService = userService;
    }

    @Override
    public void render() {

        System.out.println("\n\n\n");
        System.out.println("+-------  Create New Account  ------- +\n");
        System.out.println("What type of account would you like to add?\n");
        System.out.println("1) Checking");
        System.out.println("2) Savings");

        try {
            System.out.print("> ");
            String choice = app().getConsole().readLine();
            userService.addNewAccount(app().getCurrentSession().getSessionUser(), choice);

            if (app().getCurrentSession() != null) {
                app().getRouter().navigate("/dashboard");
            }

        }catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

    }
}
