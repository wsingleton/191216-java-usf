

package com.revature.repo;
/*
import com.revature.pojos.Accounts_Bank;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BankAccountRepoTest {

    BankAccountRepo sut;
    BankAccountRepo bankAccountRepo = mock(BankAccountRepo.class);
    UserRepo userRepo = mock(UserRepo.class);
    ConnectionFactory mockConnectionFactory = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);
    List <Accounts_Bank> mockAccounts = new ArrayList<>();

    //List <Accounts_Bank> mockAccounts = new ArrayList<>();

    @Before
    public void setUp() {


        sut = new BankAccountRepo();
        mockAccounts.add(new Accounts_Bank (1, 12));
        mockAccounts.add(new Accounts_Bank (17, 14));
        mockAccounts.add(new Accounts_Bank (21, 16));
        mockAccounts.add(new Accounts_Bank (5, 127));




    }
    @After
    public void tearDown() {

        sut = null;
        mockAccounts.remove(mockAccounts);

        }


    @Test
    public void findAccountBank() {

        Accounts_Bank accounts_bank = new Accounts_Bank(1,12);
        when(bankAccountRepo.findAccountBank(accounts_bank)).thenReturn(true);
        boolean bool = sut.updateAccountBank(accounts_bank);
        assertTrue(bool);

    }

    @Test
    public void saveAccountBank() {
    }
    Accounts_Bank accounts_bank = new Accounts_Bank(4,3);
    when(bankAccountRepo.saveAccountBank(accounts_bank)).thenReturn(true);
    boolean bool = sut.saveAccountBank(accounts_bank);
    assertTrue(bool);

    @Test
    public void updateAccountBank() {

        Accounts_Bank accounts_bank = new Accounts_Bank(2,7);
        when(bankAccountRepo.updateAccountBank(accounts_bank)).thenReturn(true);
        boolean bool = sut.updateAccountBank(accounts_bank);
        assertTrue(bool);


    }
}
*/