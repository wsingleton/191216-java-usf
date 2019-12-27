package com.revature;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private Calculator sut; //sut means SYSTEM UNDER TEST

    @Before
    public void setUp(){
    sut = new Calculator();
    }
    @After
    public void tearDown(){
        sut = null;
    }
    @Test
    public void testMultiplyWithThreeAndFive(){
        int expectedResult = 15;
        int actualResult = sut.multiply(3,5);
        assertEquals("3 times 5 is 15", expectedResult, actualResult);
    }
    @Test
    public void testMultiplyWithFiveAndThree(){
        int expectedResult = 15;
        int actualResult = sut.multiply(5,3);
        assertEquals("5 times 3 is 15", expectedResult, actualResult);
    }
    @Test
    public void testMultiplyWithZeroAndFifteen(){
        int expectedResult = 0;
        int actualResult = sut.multiply(0,15);
        assertThat( actualResult, is(expectedResult));
    }

}
