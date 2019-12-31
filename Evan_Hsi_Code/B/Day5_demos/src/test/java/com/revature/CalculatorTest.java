package com.revature;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator sut;

    @Before
    public void setUp() {
        sut = new Calculator();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testMultiplywithThreeAndFive() {
        int expectedResult = 15;
        int actualResult = sut.multiply(3,5);
        assertEquals("3 times 5 is 15", expectedResult, actualResult);
    }

    @Test
    public void testMultiplyThreebyZero() {
        int expectedResult = 0;
        int actualResult = sut.multiply(3,0);
        assertEquals("3 times 0 is 0", expectedResult, actualResult);
    }
}
