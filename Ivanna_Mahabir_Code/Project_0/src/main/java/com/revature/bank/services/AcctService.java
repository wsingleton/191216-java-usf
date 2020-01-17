package com.revature.bank.services;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.Account;
import com.revature.bank.repos.AcctRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Statement;

import static com.revature.bank.AppDriver.currentAcct;
import static com.revature.bank.AppDriver.router;

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

        return currentAcct;

    }

    public void register(String username){
        if(!acctRepo.findAcctByUsername(username).isPresent()){
            Account newAcct = new Account();
            newAcct.setBalance(0.0);
            newAcct.setUsername(username);
            newAcct.setAcctId(Statement.RETURN_GENERATED_KEYS);
            acctRepo.save(newAcct);
            currentAcct = newAcct;
        }
    }

    public Double validateDeposit(Double init, Double input){
        BigDecimal newInput = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        double deposit = newInput.doubleValue();

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

    public Double validateWith(Double init, Double input){
        BigDecimal newInput = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        double withdraw = newInput.doubleValue();
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
