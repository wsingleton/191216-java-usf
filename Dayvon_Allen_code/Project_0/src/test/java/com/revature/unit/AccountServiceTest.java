package com.revature.unit;

import com.revature.BankDriver;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;


@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"org.mockito.*"})
@PrepareForTest(BankDriver.class)

public class AccountServiceTest {
    AccountService sut;

    ArrayList<Account> mockAccount = new ArrayList<>();
//    AccountRepository acctRepo = mock(AccountRepository.class);

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
        sut.deposit(Double.toString(_expectedResult.getBalance()));
    }

    @Test(expected = InvalidRequestException.class)
    public void testWithdrawMethodValidationWithBadData() {
        Account _expectedResult = mockAccount.get(1);
        sut.deposit(Double.toString(_expectedResult.getBalance()));
    }

}
