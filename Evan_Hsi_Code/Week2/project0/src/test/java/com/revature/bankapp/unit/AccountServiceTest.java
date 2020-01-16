package com.revature.bankapp.unit;

import com.revature.bankapp.BankDriver;
import com.revature.bankapp.appState;
import com.revature.bankapp.repositories.AccountRepository;
import com.revature.bankapp.services.AccountService;
import com.revature.bankapp.services.UserService;
import com.revature.bankapp.util.ConnectionFactory;
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

public class AccountServiceTest {

    AccountService sut;
    UserService mockUserService = mock(UserService.class);
    AccountRepository accountRepository = mock(AccountRepository.class);
    UserRepository userRepository = mock(UserRepository.class);
    BankDriver mockDriver = mock(BankDriver.class);
    appState mockState = mock(appState.class);
    ConnectionFactory mockConnFac = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);

    Set<Account> mockAccounts = new HashSet<>();
    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setup() {

        sut = new AccountService(accountRepository);
        mockUsers.add(new User(1, "Evan", "Hsi", "ehsi", "p4ssw0rd", Role.ADMIN));
        mockUsers.add(new User(2, "first", "last", "username", "password", Role.BASIC_MEMBER));
        mockUsers.add(new User(3, "one", "two", "three", "four", Role.BASIC_MEMBER));
        mockUsers.add(new User(4, "a", "b", "c", "d", Role.BASIC_MEMBER));

        mockAccounts.add(new Account(1, 5, Type.CHECKING));
        mockAccounts.add(new Account(2, 100, Type.CHECKING));
        mockAccounts.add(new Account(3, 0, Type.CHECKING));
        mockAccounts.add(new Account(4, 47.15, Type.CHECKING));

    }

    @After
    public void teardown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
        mockAccounts.removeAll(mockAccounts);
    }

    @Test
    public void withdrawalTest() {
        when(accountRepository.withdraw(1, 1)).thenReturn(true);
        boolean bool = sut.withdrawal(1, 1);
        assertTrue(bool);
    }

    @Test
    public void withdrawalTest2() {
        when(accountRepository.withdraw(1, 10)).thenReturn(false);
        boolean bool = sut.withdrawal(1, 10);
        assertFalse(bool);
    }


}
