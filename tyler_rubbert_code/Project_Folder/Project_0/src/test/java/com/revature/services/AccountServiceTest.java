package com.revature.services;

import com.revature.project_0.AppDriver;
import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.AccountType;
import com.revature.project_0.repos.AccountRepository;
import com.revature.project_0.repos.UserAccountRepository;
import com.revature.project_0.services.AccountService;
import com.revature.project_0.util.AppState;
import com.revature.project_0.util.UserSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AppDriver.class)
@PowerMockIgnore({"org.mockito.*"})
public class AccountServiceTest {

    AccountService accountService;
    AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    UserAccountRepository uaRepo = Mockito.mock(UserAccountRepository.class);
    AppDriver mockDriver = Mockito.mock(AppDriver.class);
    AppState mockState = Mockito.mock(AppState.class);
    UserSession mockSession = Mockito.mock(UserSession.class);

    Set<Account> mockAccounts = new HashSet<>();
    Account mockAccount;

    @Before
    public void setup(){
        accountService = new AccountService(accountRepository,uaRepo);
        mockAccounts.add(new Account(1, 400.01, AccountType.CHECKINGS));
        mockAccounts.add(new Account(2, 350.49, AccountType.CHECKINGS));
        mockAccounts.add(new Account(3, 10000.98, AccountType.CHECKINGS));
        Account mockAccount = new Account(1,1000, AccountType.CHECKINGS);
    }

    @After
    public void tearDown() {
        accountService = null;
        mockAccounts.removeAll(mockAccounts);
    }

    @Test
    public void withdrawMoreThanBalance() {
        mockStatic(AppDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);

    }

    @Test
    public void depositIntoAccount() {
        mockStatic(AppDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);

    }



}
