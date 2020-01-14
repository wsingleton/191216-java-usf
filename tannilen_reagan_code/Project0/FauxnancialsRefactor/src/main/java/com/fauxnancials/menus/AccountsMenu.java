package com.fauxnancials.menus;

import com.fauxnancials.services.AcctService;

public class AccountsMenu extends Menu {
    private AcctService acctService;
    public AccountsMenu(AcctService acctService) {
        super("Accounts Overview", "/accounts");
        this.acctService=acctService;
    }
    @Override
    public void render() {
    }
}
