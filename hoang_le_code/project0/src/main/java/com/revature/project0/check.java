package com.revature.project0;

import com.revature.project0.repos.AccountRepository;

public class check {
    public static void main (String[] args){

        AccountRepository ac =new AccountRepository();
        ac.getBalance("Checking", 2);
    }
}
