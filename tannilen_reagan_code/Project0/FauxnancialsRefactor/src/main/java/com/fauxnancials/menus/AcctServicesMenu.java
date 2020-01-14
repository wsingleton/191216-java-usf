package com.fauxnancials.menus;

import com.fauxnancials.services.AcctService;

public class AcctServicesMenu extends Menu {
    private AcctService acctService;
    public AcctServicesMenu(AcctService acctService) {
        super("Account Services", "/new_accts");
        this.acctService=acctService;
    }
    @Override
    public void render() {
    }
}
