package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.app;

public class SwitchAccountsScreen extends Screen {

    private UserService userService;

    public SwitchAccountsScreen(UserService userService) {
        super("SwitchScreen", "/switch");
        this.userService = userService;
    }
    @Override
    public void render() {

        userService.chooseAccount(app().getCurrentSession().getSessionUser());

        if (app().isSessionValid()) {
            System.out.println("[LOG - You have now switched to your " +
                    app().getCurrentSession().getSessionAccount().getAccountType());
            app().getRouter().navigate("/dashboard");
        }

    }
}
