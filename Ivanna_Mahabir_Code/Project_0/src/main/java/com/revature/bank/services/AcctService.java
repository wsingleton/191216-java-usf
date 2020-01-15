package com.revature.bank.services;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.models.Account;
import com.revature.bank.repos.AcctRepository;

import static com.revature.bank.AppDriver.currentAcct;
import static com.revature.bank.AppDriver.router;

public class AcctService {

    private AcctRepository acctRepo;

    public AcctService(AcctRepository repo){ this.acctRepo = repo; }



    public Account getAcctByUsername(String username){
        currentAcct = acctRepo.findAcctByUsername(username).orElseThrow(AuthenticatironException::new);
        if(currentAcct.getBalance() == null || currentAcct.getBalance().equals("")){
            currentAcct.setUsername(username);
            currentAcct.setBalance(0.0);
        }
        return currentAcct;

    }

    public Double validateDeposit(Double deposit){
        if(deposit >= 0 ){
            deposit = currentAcct.getBalance() + deposit;
        }
        else{
            System.out.println("Invalid Deposit Amount Entered");
            router.navigate("/profile");
        }
        return deposit;
    }

    public Double validateWith(Double withdraw){
        if(withdraw >= 0 ){
            if(withdraw < currentAcct.getBalance()) withdraw -= currentAcct.getBalance();
            else {
                System.out.println("Invalid Withdrawal Amount Entered");
                router.navigate("/profile");
            }
        }
        else{
            System.out.println("Invalid Withdrawal Amount Entered");
            router.navigate("/profile");
        }
        return withdraw;
    }
    //validate deposit, withdrawal, new acct set deposit 0
}
