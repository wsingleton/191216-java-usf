package com.revature.bankapp.unit;

import com.revature.bankapp.BankDriver;
import com.revature.bankapp.appState;
import com.revature.bankapp.repositories.AccountRepository;
import com.revature.bankapp.services.AccountService;
import com.revature.bankapp.services.UserService;
import com.revature.bankapp.util.ConnectionFactory;
import com.revature.bankapp.services.TransactionService;
import com.revature.bankapp.repositories.TransactionRepository;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import com.revature.bankapp.services.UserService.*;
import com.revature.bankapp.exceptions.*;
import com.revature.bankapp.models.*;
import com.revature.bankapp.repositories.UserRepository;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BankDriver.class)
@PowerMockIgnore({"org.mockito.*"})

public class TransactionServiceTest {

    TransactionService sut;
    UserService mockUserService = mock(UserService.class);
    TransactionService mockTransactionService = mock(TransactionService.class);
    TransactionRepository transactionRepository = mock(TransactionRepository.class);
    AccountRepository accountRepository = mock(AccountRepository.class);
    UserRepository userRepository = mock(UserRepository.class);
    BankDriver mockDriver = mock(BankDriver.class);
    appState mockState = mock(appState.class);
    ConnectionFactory mockConnFac = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);

    Set<Account> mockAccounts = new HashSet<>();
    Set<User> mockUsers = new HashSet<>();
    Set<Transaction> mockTransactions = new HashSet<>();

    @Before
    public void setup() {

        sut = new TransactionService(transactionRepository);
        mockUsers.add(new User(1, "Evan", "Hsi", "ehsi", "p4ssw0rd", Role.ADMIN));
        mockUsers.add(new User(2, "first", "last", "username", "password", Role.BASIC_MEMBER));
        mockUsers.add(new User(3, "one", "two", "three", "four", Role.BASIC_MEMBER));
        mockUsers.add(new User(4, "a", "b", "c", "d", Role.BASIC_MEMBER));

        mockAccounts.add(new Account(1, 5, Type.CHECKING));
        mockAccounts.add(new Account(2, 100, Type.CHECKING));
        mockAccounts.add(new Account(3, 0, Type.CHECKING));
        mockAccounts.add(new Account(4, 47.15, Type.CHECKING));

        mockTransactions.add(new Transaction(1, 1, "date", 1, TransactionType.DEPOSIT));
        mockTransactions.add(new Transaction(2, 1, "date", 5, TransactionType.DEPOSIT));
        mockTransactions.add(new Transaction(3, 1, "date", 2, TransactionType.DEPOSIT));



    }

    @After
    public void teardown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
        mockAccounts.removeAll(mockAccounts);
        mockTransactions.removeAll(mockTransactions);
    }

    @Test
    public void testFindById() {
        when(transactionRepository.findByAccount(1)).thenReturn(mockTransactions);
        Set<Transaction> result = sut.findByID(1);
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testFindById2() {
        when(transactionRepository.findByAccount(2)).thenReturn(null);
        Set<Transaction> result = sut.findByID(2);
        assertEquals(result, null);
    }
}
