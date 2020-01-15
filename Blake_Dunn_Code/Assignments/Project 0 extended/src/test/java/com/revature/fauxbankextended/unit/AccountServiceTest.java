package com.revature.fauxbankextended.unit;

import com.revature.fauxbankextended.BankDriver;
import com.revature.fauxbankextended.models.*;
import com.revature.fauxbankextended.repos.AccountRepository;
import com.revature.fauxbankextended.repos.TransactionRepository;
import com.revature.fauxbankextended.repos.UserRepository;
import com.revature.fauxbankextended.services.AccountService;
import com.revature.fauxbankextended.util.AppState;
import com.revature.fauxbankextended.util.ConnectionFactory;
import com.revature.fauxbankextended.util.ScreenRouter;
import com.revature.fauxbankextended.util.UserSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest({BankDriver.class, ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*"})
public class AccountServiceTest {

    AccountService sut;
    AccountRepository acctRepo = mock(AccountRepository.class);
    TransactionRepository transRepo = mock(TransactionRepository.class);
    BankDriver mockDriver = mock(BankDriver.class);
    AppState mockState = mock(AppState.class);
    UserSession mockSession = mock(UserSession.class);
    Account mockAcct = mock(Account.class);
    User mockUser = mock(User.class);
    Transaction mockTrans = mock(Transaction.class);

    @Before
    public void setUp() {
        sut = new AccountService(acctRepo, transRepo);
        mockAcct = new Account(1, 500.0, AccountType.CHECKING);
    }

    @After
    public void tearDown() {
        sut = null;
        mockAcct = null;
    }

    @Test
    public void testValidateDepositWithNullString() {
        Double balance = 500.0;
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        assertFalse(sut.validateDeposit(null));
    }

    @Test
    public void testValidateDepositWithEmptyString() {
        Double balance = 500.0;
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        assertFalse(sut.validateDeposit(""));
    }

    @Test
    public void testValidateDepositWithCharacterString() {
        Double balance = 500.0;
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        assertFalse(sut.validateDeposit("asdfsdf"));
    }
    @Test
    public void testValidateDepositWithValidString() {
        Double deposit = 500.0;
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        Transaction mockTrans = new Transaction(1, 1,deposit, TransactionType.DEPOSIT);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        when(mockSession.getSessionUser()).thenReturn(user);
        when(mockUser.getId()).thenReturn(1);
        transRepo.save(mockTrans);
        acctRepo.update(acct);
        assertTrue(sut.validateDeposit("45"));
    }

    @Test
    public void testValidateDepositWithExtraDecimals() {
        Double deposit = 500.0;
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        Transaction mockTrans = new Transaction(1, 1,deposit, TransactionType.DEPOSIT);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        when(mockSession.getSessionUser()).thenReturn(user);
        when(mockUser.getId()).thenReturn(1);
        transRepo.save(mockTrans);
        acctRepo.update(acct);
        assertTrue(sut.validateDeposit("45.000000000"));

    }

    @Test
    public void testValidateDepositWithNegativeString() {
        Double balance = 500.0;
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        assertFalse(sut.validateDeposit("-45.00"));
    }

    @Test
    public void testValidateDepositWithValidStringGreaterThanLimitAllowed() {
        Double balance = 500.0;
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        assertFalse(sut.validateDeposit("10001.0"));
    }

    @Test
    public void testValidateWithdrawWithNullString() {
        Double balance = 500.0;
        Boolean actualResult = sut.validateWithdraw(balance, null);
        assertEquals("Try again!", false, actualResult);

    }

    @Test
    public void testValidateWithdrawWithEmptyString() {
        Double balance = 500.0;
        Boolean actualResult = sut.validateWithdraw(balance, "");
        assertEquals("Try again!", false, actualResult);
    }

    @Test
    public void testValidateWithdrawWithCharacterString() {
        Double balance = 500.0;
        Boolean actualResult = sut.validateWithdraw(balance, "abcdefg");
        assertEquals("Try again!", false, actualResult);
    }

    @Test
    public void testValidateWithdrawWithValidString() {
        Double balance = 500.0;
        Double withdraw = 500.0;
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        Transaction mockTrans = new Transaction(1, 1, withdraw, TransactionType.DEPOSIT);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        when(mockSession.getSessionUser()).thenReturn(user);
        when(mockUser.getId()).thenReturn(1);
        transRepo.save(mockTrans);
        acctRepo.update(acct);
        assertTrue(sut.validateWithdraw(balance, "45"));

    }

    @Test
    public void testValidateWithdrawWithExtraDecimals() {
        Double balance = 500.0;
        Double withdraw = 500.0;
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        Account acct = new Account(1, 500.0, AccountType.CHECKING);
        Transaction mockTrans = new Transaction(1, 1, withdraw, TransactionType.DEPOSIT);
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.getSessionAccount()).thenReturn(acct);
        when(mockSession.getSessionUser()).thenReturn(user);
        when(mockUser.getId()).thenReturn(1);
        transRepo.save(mockTrans);
        acctRepo.update(acct);
        assertTrue(sut.validateWithdraw(balance, "45.00000000"));
    }

    @Test
    public void testValidateWithdrawWithNegativeString() {
        Double balance = 500.0;
        assertFalse(sut.validateWithdraw(balance, "-45.0"));
    }

    @Test
    public void testValidateWithdrawWithValidStringGreaterThanLimitAllowed() {
        Double balance = 50.0;
        assertFalse(sut.validateWithdraw(balance,"55.0"));
    }

    @Test
    public void testConvertAmountWithValidDouble() {
        Double actualResult = sut.convertAmount(100.94);
        Double expectedResult = 100.94;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testConvertAmountWithValidDoubleWithExtraDecimals() {
        Double actualResult = sut.convertAmount(100.948473643);
        Double expectedResult = 100.94;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testConvertAmountWithZero() {
        Double actualResult = sut.convertAmount(0.0);
        Double expectedResult = 0.0;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testConvertAmountWithZeroAndExtraDecimals() {
        Double actualResult = sut.convertAmount(0.000000000);
        Double expectedResult = 0.0;
        assertEquals(actualResult, expectedResult);
    }
}
