package com.revature.bank.services;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.Account;
import com.revature.bank.repos.AcctRepository;

import static com.revature.bank.AppDriver.*;

public class AcctService {

    private AcctRepository acctRepo;

    public AcctService(AcctRepository repo){ this.acctRepo = repo; }


    public Account getAcctByUsername(String username){
        if(username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }
        if(acctRepo.findAcctByUsername(username).isPresent()) {
            currentAcct = acctRepo.findAcctByUsername(username).orElseThrow(AuthenticatironException::new);
        }
        else{
            Account newAcct = new Account(username);
            acctRepo.save(newAcct);
            currentAcct = newAcct;
        }
        return currentAcct;

    }

    public Double validateDeposit(Double init, Double deposit){
        if(deposit >= 0 ){
            deposit += init;
            currentAcct.setBalance(deposit);
            acctRepo.updateAcct(currentAcct.getUsername(),deposit);
        }
        else{
            System.out.println("Invalid Deposit Amount Entered\n\n");
            router.navigate("/profile");
        }
        return deposit;
    }

    public Double validateWith(Double init, Double withdraw){
        if(withdraw >= 0 ){
            if(withdraw <= init){
                withdraw = init - withdraw;
                currentAcct.setBalance(withdraw);
                acctRepo.updateAcct(currentAcct.getUsername(), withdraw);
            }
            else {
                System.out.println("Invalid Withdrawal Amount Entered\n\n");
                router.navigate("/profile"); }
        } else{
            System.out.println("Invalid Withdrawal Amount Entered\n\n");
            router.navigate("/profile");
        }

        return withdraw;
    }


}
