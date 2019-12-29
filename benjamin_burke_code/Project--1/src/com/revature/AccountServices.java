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

    ArrayList<Account> getAllAccounts() {


        DAO dao = new DAO();
        return dao.readAccounts();
    }

    public Account addAccount(String username, String password, Double balance){

        Account a = new Account(username, password, balance);
        //logic needds to in here
        DAO dao = new DAO();
        dao.addAccount(a);
        return a;
    }

    boolean exists(String username){
        ArrayList<Account> accounts = getAllAccounts();
        return accounts.stream().anyMatch(s->s.getUsername().equalsIgnoreCase(username));
    }

    Account getByUsername(String username){
        return getAllAccounts().stream().filter(s->s.getUsername().equalsIgnoreCase(username)).findFirst().get();
    }

    void updateBalance(Account ac){
        DAO dao = new DAO();
        ArrayList<Account> temp = dao.readAccounts();

        for (Account a : temp){
            if(a.getUsername().equals(ac.getUsername())) {
                a.setBalance(a.getBalance());
            }
        }
        //dao needs update
        dao.updateAccount(temp);
    }

}
