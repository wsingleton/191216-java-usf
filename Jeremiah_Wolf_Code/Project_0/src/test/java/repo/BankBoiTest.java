package com.bankboi.repo;

import com.bankboi.plainjava.BankAccounts;
import com.bankboi.repos.bankboirepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BankBoiTest {
    bankboirepo sut;
    bankboirepo bankAccountRepo = mock(bankboirepo.class);
    // List<Accounts_Bank> = new List<>();

    @Before
    public void setUp() {
        sut = new bankboirepo();

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