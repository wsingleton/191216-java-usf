package com.revature.bank.services;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.exceptions.ResourcePersistenceException;
import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.repos.AcctRepository;


import java.util.Set;

import static com.revature.bank.AppDriver.currentAcct;
import static com.revature.bank.AppDriver.currentUser;

public class AcctService {

    private AcctRepository acctRepo;

    public AcctService(AcctRepository repo){ this.acctRepo = repo; }

    public Account getAcctByUsername(String username){
        currentAcct = acctRepo.findAcctByUsername(username).orElseThrow(AuthenticatironException::new);
        if(currentAcct.getBalance() == null || currentAcct.getBalance().equals("")){
            currentAcct.setBalance(0.0);
        }
        return currentAcct;

    }

    public Double validateInput(Double balance){
        if(currentAcct.getBalance() < 0)
    }

    //validate deposit, withdrawal, new acct set deposit 0
}
