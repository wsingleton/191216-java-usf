package com.revature.mockbank;

import com.revature.mockbank.models.Account;
import com.revature.mockbank.models.AccountAccess;
import com.revature.mockbank.models.AccountType;
import com.revature.mockbank.repositories.AccountRepo;

import java.time.LocalDateTime;

public class Test {

    public static void main (String... args){
        Account myAccount = new Account();
        myAccount.setAccount_id(1);
        myAccount.setAccount_type(AccountType.CHECKING);
        myAccount.setAccount_access(AccountAccess.SHARED);
        myAccount.setBalance(30.0);
        //System.out.println(myAccount.toString());
        AccountRepo acRepo = new AccountRepo();
        acRepo.save(myAccount);

    }
}
