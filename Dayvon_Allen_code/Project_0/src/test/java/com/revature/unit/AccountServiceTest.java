package com.revature.unit;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.services.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;

public class AccountServiceTest {
    AccountService sut;

    ArrayList<Account> mockAccount = new ArrayList<>();

    @Before
    public void setUp() {
        sut = new AccountService();
        mockAccount.add(new Account(Integer.toString("test".hashCode()), 230.05));
        mockAccount.add(new Account(Integer.toString("user".hashCode()), 230.333));

    }

    @After
    public void tearDown() {
        sut = null;
        mockAccount.removeAll(mockAccount);
    }

    @Test(expected = InvalidRequestException.class)
    public void testDepositMethodValidationWithBadData() {
        Account _expectedResult = mockAccount.get(1);
        System.out.println(mockAccount.get(1).getBalance());
        sut.deposit(Double.toString(_expectedResult.getBalance()));
    }

    @Test(expected = InvalidRequestException.class)
    public void testWithdrawMethodValidationWithBadData() {
        Account _expectedResult = mockAccount.get(1);
        System.out.println(mockAccount.get(1).getBalance());
        sut.deposit(Double.toString(_expectedResult.getBalance()));
    }
}
