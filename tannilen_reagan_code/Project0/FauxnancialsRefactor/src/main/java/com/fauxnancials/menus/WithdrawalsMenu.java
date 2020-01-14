package com.fauxnancials.menus;

import com.fauxnancials.services.AcctService;

public class WithdrawalsMenu extends Menu {
    private AcctService acctService;
    public WithdrawalsMenu(AcctService acctService) {
        super("Withdrawals", "/withdrawals");
        this.acctService=acctService;
    }
    @Override
    public void render() {
    }
}
