package com.revature.services;

import com.revature.fauxbank.models.Account;
import com.revature.fauxbank.services.AccountService;
import org.junit.*;

import static com.revature.fauxbank.BankDriver.currentAccount;
import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

//    private AccountService sut;
//
    @Before
    public void setUp() {
        sut = new AccountService();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testValidateDepositWithNullString() {
        Double actualResult = sut.validateDeposit(null);
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);

    }

    @Test
    public void testValidateDepositWithEmptyString() {
        Double actualResult = sut.validateDeposit("");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateDepositWithCharacterString() {
        Double actualResult = sut.validateDeposit("abcdefg");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateDepositWithValidString() {
        Double expectedResult = 45.0;
        Double actualResult = sut.validateDeposit("45");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidateDepositWithExtraDecimals() {
        Double expectedResult = 45.0;
        Double actualResult = sut.validateDeposit("45.000000000");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidateDepositWithNegativeString() {
        Double actualResult = sut.validateDeposit("-45.0");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateDepositWithValidStringGreaterThanLimitAllowed() {
        Double actualResult = sut.validateDeposit("100000.0");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateWithdrawWithNullString() {
        Double actualResult = sut.validateWithdraw(null);
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);

    }

    @Test
    public void testValidateWithdrawWithEmptyString() {
        Double actualResult = sut.validateWithdraw("");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateWithdrawWithCharacterString() {
        Double actualResult = sut.validateWithdraw("abcdefg");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateWithdrawWithValidString() {
        currentAccount = new Account(1, 50.0);
        Double expectedResult = 45.0;
        Double actualResult = sut.validateWithdraw("45");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidateWithdrawWithExtraDecimals() {
        currentAccount = new Account(1, 50.0);
        Double expectedResult = 45.0;
        Double actualResult = sut.validateWithdraw("45.000000000");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidateWithdrawWithNegativeString() {
        currentAccount = new Account(1, 50.0);
        Double actualResult = sut.validateWithdraw("-45.0");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
    }

    @Test
    public void testValidateWithdrawWithValidStringGreaterThanLimitAllowed() {
        currentAccount = new Account(1, 50.0);
        Double actualResult = sut.validateWithdraw("55.0");
        Double expectedResult = 0.0;
        assertEquals("Try again!", expectedResult, actualResult);
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
