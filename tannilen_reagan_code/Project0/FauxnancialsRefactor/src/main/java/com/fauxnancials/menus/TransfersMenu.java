package com.fauxnancials.menus;

import com.fauxnancials.services.AcctService;

public class TransfersMenu extends Menu {
    private AcctService acctService;
    public TransfersMenu(AcctService acctService) {
        super("Transfers", "/transfers");
        this.acctService=acctService;
    }
    @Override
    public void render() {
    }
}
