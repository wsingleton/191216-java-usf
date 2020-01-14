package com.fauxnancials.services;

import com.fauxnancials.repos.AccountRepository;

public class AcctService {
    private AccountRepository acctRepo;
    public AcctService(AccountRepository repo) {
        this.acctRepo=repo;
    }
}