package com.revature.mockBank.services;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.services.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

    private AccountService sut; // System under test
    private double testAmount;
    private Double expectedResult;
    private Double actualResult;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp() {
        sut = new AccountService();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testValidateAmountWithInt() {

        // Arrange
        String message = "If an integer is provided, the implementation should convert it into a double with 2 decimal places";
        testAmount = 500;
        expectedResult = 500.00;

        // Act
        actualResult = sut.validatedAmount(testAmount);

        // Assert
        assertEquals(message, expectedResult, actualResult);

    }


    @Test
    public void testValidateAmountWithNegativeNumber() {
        String message = "If a negative number is provided, the system should throw an invalid input error";
        testAmount = -80;
        expectedResult = 0.0;
//        InvalidRequestException expectedException = new InvalidRequestException();
//        expectedResult = throw new InvalidRequestException();
        actualResult = sut.validatedAmount(testAmount);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testValidateAmountWithPreValidatedDouble() {
        String message = "If a provided number is already formatted correctly, return that number";
        testAmount = 678.89;
        expectedResult = 678.89;
        actualResult = sut.validatedAmount(testAmount);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testValidateAmountWithManyDecimals() {
        String message = "If a double with many decimals is provided, return only 2 decimal places rounded down";
        testAmount = 780.46777775567777;
        expectedResult = 780.46;
        actualResult = sut.validatedAmount(testAmount);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testValidateAmountWithManyZeroDecimals(){
        String message = "if a double given has many zeros, the program will format it to two decimal places";
        testAmount = 451.0000000000000000000000;
        expectedResult = 451.0;
        actualResult = sut.validatedAmount(testAmount);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testValidateAmountWithZero() {
        testAmount = 0;
        String message = "If a null object is provided, return 0";
        assertEquals(message, new Double(0.0), sut.validatedAmount(testAmount));
    }

}
