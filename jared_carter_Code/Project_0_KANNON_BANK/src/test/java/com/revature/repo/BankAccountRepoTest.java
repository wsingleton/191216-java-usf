package com.revature.repo;

import com.revature.pojos.Accounts_Bank;
import com.revature.pojos.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BankAccountRepoTest {
    BankAccountRepo sut;
    BankAccountRepo bankAccountRepo = mock(BankAccountRepo.class);
   // List<Accounts_Bank> = new List<>();

    @Before
    public void setUp() {
        sut = new BankAccountRepo();

    /*mockUsers.add(new User();
                .setId(1);
                .setAccountOwner(12);
                .setBalance(1017);

      mockUsers.add(new User();
                .setId(1);
                .setAccountOwner(12);
                .setBalance(1017);

    */
    }
    @After
    public void tearDown() {

        sut = null;
        //mockUsers.removeAll(Users);

        }

    @Test
    public void findAllBankAcc() {
    }

    @Test
    public void findAccountBank() {
    }

    @Test
    public void saveAccountBank() {
    }

    @Test
    public void updateAccountBank() {
    }
}