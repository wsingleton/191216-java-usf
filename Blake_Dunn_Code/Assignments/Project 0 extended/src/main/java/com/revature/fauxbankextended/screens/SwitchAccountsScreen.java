package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.services.AccountService;

import static com.revature.fauxbankextended.BankDriver.app;

public class SwitchAccountsScreen extends Screen {

    private AccountService accountService;

    public SwitchAccountsScreen(AccountService accountService) {
        super("SwitchScreen", "/switch");
        this.accountService = accountService;
    }
    @Override
    public void render() {

        System.out.println("+-------  Switch Account  ------- +\n");

        accountService.chooseAccount(app().getCurrentSession().getSessionUser());

        if (app().isSessionValid()) {
            System.out.println("[LOG - You have now switched to your " +
                    app().getCurrentSession().getSessionAccount().getAccountType() + " account.");
            app().getRouter().navigate("/dashboard");
        }

    }
}
