package com.revature.project0.services;

import com.revature.project0.models.Accounts;
import com.revature.project0.models.User;
import com.revature.project0.repos.AccountRepository;
import com.revature.project0.repos.UserRepository;

import static org.junit.Assert.*;

public class ServiceTest {


    @org.junit.Test
    public void register() {
        User u1 = new User("test5","test5","test5","test5");


        UserRepository a = new UserRepository();
        UserService check = new UserService(a);
        UserRepository a1 = new UserRepository();
        check.register(u1);
        assertTrue(
                a.checkUsername("test5"));
    }

    @org.junit.Test
    public void createAccount() {
        AccountRepository a = new AccountRepository();
        Accounts acc = new Accounts("Checking",1000.0);
        a.save2(acc,3);
        assertTrue(a.checkAccount(3));

    }

    @org.junit.Test
    public void deposit() {
        AccountRepository ar = new AccountRepository();
        Double a = ar.getBalance("Saving",3);
        Double amount = 500.0;
        Double newbalance = a + amount;
        ar.deposit("Saving",amount,3);
        AccountRepository ar1 = new AccountRepository();
        Double check = ar1.getBalance("Saving",3);

        assertTrue(
                newbalance.equals(check)

        );


    }

    @org.junit.Test
    public void withdraw() {
        AccountRepository ar = new AccountRepository();
        Double a = ar.getBalance("Saving",3);
        Double amount = 500.0;
        Double newbalance = a - amount;
        ar.withdraw("Saving",amount,3);
        AccountRepository ar1 = new AccountRepository();
        Double check = ar1.getBalance("Saving",3);

        assertTrue(
                newbalance.equals(check)

        );

    }




}