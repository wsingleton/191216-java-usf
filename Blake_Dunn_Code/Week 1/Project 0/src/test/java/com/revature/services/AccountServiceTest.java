package com.revature.services;

import com.revature.fauxbank.exceptions.InvalidAmountException;
import com.revature.fauxbank.services.AccountService;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

    private AccountService sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
        sut.validateDeposit(null);
        expectedException.expect(InvalidAmountException.class);
        expectedException.expectMessage("That is not valid amount.");
    }

    @Test
    public void testValidateDepositWithEmptyString() {
        sut.validateDeposit("");
        expectedException.expect(InvalidAmountException.class);
        expectedException.expectMessage("That is not valid amount.");
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
        String expectedResult = "Try again!";
        Double actualResult = sut.validateDeposit("-45");
        assertEquals(expectedResult, actualResult);
    }
}
