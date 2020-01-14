package com.fauxnancials.services;

import com.fauxnancials.AppDriver;
import com.fauxnancials.models.Acct;
import com.fauxnancials.repos.AccountRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AcctService {
    private AccountRepository acctRepo;
    public AcctService(AccountRepository repo) {
        this.acctRepo=repo;
    }
    private Set<Acct> userAccts=new HashSet<>();
    public void populateAccounts() {
        userAccts=acctRepo.findByOwner(AppDriver.currentUser.getUserID());
    }
    public void showBals() {
        if (userAccts!=null && !userAccts.isEmpty()) {
            for (Acct a : userAccts) {
                a.acctShow();
                System.out.println("");
            }
        }
        else {
            System.out.println("No accounts found for " + AppDriver.currentUser.getGivenName() + " " + AppDriver.currentUser.getFamilyName() + ".");
        }
    }
}