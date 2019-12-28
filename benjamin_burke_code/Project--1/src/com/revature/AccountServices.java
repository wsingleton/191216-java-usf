package com.revature;

import com.revature.models.Account;

import java.util.ArrayList;

public class AccountServices {
    //create the array list to hold all the accounts to be added
    static ArrayList<Account>accounts;
    static {
        accounts = new ArrayList<Account>();
        accounts.add(new Account("Benji", "Bruce", 0));
    }

    

    public Account addAccount(String username, String password, Double balance){

        Account a = new Account(username, password, balance);
        //logic needds to in here
        DAO dao = new DAO();
        dao.addAccount(a);
        return a;
    }
}
