package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;
import com.fauxnancials.services.AcctService;

import static com.fauxnancials.util.AnsiColours.ANSI_BLUE;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class AccountsMenu extends Menu {
    private AcctService acctService;
    public AccountsMenu(AcctService acctService) {
        super("Accounts Overview", "/accounts");
        this.acctService=acctService;
    }
    @Override
    public void render() {
        System.out.println(ANSI_BLUE + "Accounts belonging to " + AppDriver.currentUser.getGivenName() + " " + AppDriver.currentUser.getFamilyName() + ":" + ANSI_RESET);
        acctService.showBals();
        System.out.println("");
        System.out.println("Returning to dashboard...");
        AppDriver.router.navigate("/dashboard");
    }
}
