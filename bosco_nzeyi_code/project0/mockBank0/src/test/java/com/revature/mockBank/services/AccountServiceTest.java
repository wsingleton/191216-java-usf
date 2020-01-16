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
    private String messagelog;

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

    // testing isNumeric method

    @Test
    public void testIsNumeric(){
        messagelog = "If a string provided can be parsed into a double i.e contains numbers only, the method should return true";
        String testAmount = "100.567";
        boolean expectedResult = true;
        boolean actualResult = sut.isNumeric(testAmount);
        assertEquals(messagelog, expectedResult, actualResult);

    }

    @Test
    public void testIsNumericWithStringsOnly(){
        messagelog = "If a string provided does not contain any number, the method should return false";
        String testAmount = "Kitabi";
        boolean expectedResult = false;
        boolean actualResult = sut.isNumeric(testAmount);
        assertEquals(messagelog, expectedResult, actualResult);

    }

    @Test
    public void testIsNumericWithStringMixedWithNumbers(){
        messagelog = "If a string provided is a mix of numbers and characters, the method should return false";
        String testAmount = "1250Kitabi";
        boolean actualResult = sut.isNumeric(testAmount);
        assertEquals(messagelog, false, actualResult);
    }

    @Test
    public void testIsNumericWithEmptyInput(){
        messagelog = "If a string provided is empty, the method should return false";
        String testAmount = "";
        boolean actualResult = sut.isNumeric(testAmount);
        assertEquals(messagelog, false, actualResult);
    }

    @Test
    public void testIsNumericWithNullInput(){
        messagelog = "If no input provided, the method should return false";
        boolean actualResult = sut.isNumeric(null);
        assertEquals(messagelog, false, actualResult);
    }

    // Tests for negative value checker method

    @Test
    public void testNegativeValuesCheckerWithANegativeNumber(){
        messagelog = "If an amount provided is less or equal to zero, the method should return true";
        double testAmount = -456.89;
        boolean actualResult = sut.negativeValuesChecker(testAmount);
        assertEquals(messagelog, true, actualResult);
    }

    @Test
    public void testNegativeValuesCheckerWithAPositiveNumber(){
        messagelog = "If an amount provided is greater than zero, the method should return false";
        double testAmount = 45689;
        boolean actualResult = sut.negativeValuesChecker(testAmount);
        assertEquals(messagelog, false, actualResult);
    }


}
