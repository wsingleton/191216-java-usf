package com.liberationbank.servicestest;

import com.liberationbank.services.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class AccountServiceTest {
    private AccountService sut;
    /*
    JUnit rules is a component that intercepts test method calls and allows us to do something before a test method has
     run - typically adding additional constraints to the test case.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp(){
        sut = new AccountService();
    }
    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testValidateWithdrawal(){
        String message = "if a negative number is input, return false";
        double testWithdrawalValue = 500;
        double testBalanceValue = 5000;
        boolean actualResult = sut.validateWithdrawBalance(testWithdrawalValue, testBalanceValue);
        assertFalse(message, actualResult);
    }

    @Test
    public void testValidateWithdrawalForNegativeWithdrawal(){
        String message = "if a negative number is input, return false";
        double testWithdrawalValue = -5;
        double testBalanceValue = 5000;
        boolean actualResult = sut.validateWithdrawBalance(testWithdrawalValue, testBalanceValue);
        assertFalse(message, actualResult);
    }

    @Test
    public void testValidateWithdrawalForOverDraft(){
        String message = "if a negative number is input, return false";
        double testWithdrawalValue = 5001;
        double testBalanceValue = 5000;
        boolean actualResult = sut.validateWithdrawBalance(testWithdrawalValue, testBalanceValue);
        assertFalse(message, actualResult);
    }

    @Test
    public void testValidateDepositForMaxDeposit(){
        String message = "if a negative number is input, return false";
        double testDepositValue = 5001;
        boolean actualResult = sut.validateDeposit(testDepositValue);
        assertFalse(message, actualResult);
    }

    @Test
    public void testValidateDepositForNegativeNumber(){
        String message = "if a negative number is input, return false";
        double testDepositValue = -12;
        boolean actualResult = sut.validateDeposit(testDepositValue);
        assertFalse(message, actualResult);
    }

    @Test
    public void testValidateDeposit(){
        String message = "if a negative number is input, return false";
        double testDepositValue = 12;
        boolean actualResult = sut.validateDeposit(testDepositValue);
        assertFalse(message, actualResult);


    }

    @Test
    public void testSolutionWithFourPlaces(){
        String message = "If a negative number is input";
        double testValue = 12.3654;
        double expectedResult = 12.36;
        double actualResult = sut.sanitizeValue(testValue);
        assertEquals(message,expectedResult, actualResult, expectedResult);
    }

    @Test
    public void testSolutionWithTwoPlaces(){
        String message = "If a reversed array is provided, the implementation should sort the array";
        double testArray = 50.99;
        double expectedResult = 50.99;
        double actualResult = sut.sanitizeValue(testArray);
        assertEquals(message,expectedResult,actualResult, expectedResult);
    }


}
