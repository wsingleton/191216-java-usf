package com.fauxnancials.menus;

import com.fauxnancials.services.AcctService;

public class DepositsMenu extends Menu {
    private AcctService acctService;
    public DepositsMenu(AcctService acctService) {
        super("Deposits", "/deposits");
        this.acctService=acctService;
    }
    @Override
    public void render() {
    }
}
