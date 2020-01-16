package com.revature.bankapp.screens;

import com.revature.bankapp.services.AccountService;

public class AddUserScreen extends Screen {

    private AccountService accountService;

    public AddUserScreen() {
        super("AddUserScreen", "/adduserscreen");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public AddUserScreen(AccountService accountService) {
        super("AddUserScreen", "/adduserscreen");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render() {

    }
}
