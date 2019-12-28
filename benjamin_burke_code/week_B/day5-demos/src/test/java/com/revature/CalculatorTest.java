package com.revature;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {

    private Calculator sut;

    @Before
    public void setUp(){
        sut = new Calculator();

    }

    @After
    public void tearDwon(){
        sut = null;

    }

    @Test
    public void testMultiplyWithFiveAndThree(){
        int expectedResult = 15;
        int actualResult = sut.multiply(5, 3);
        assertEquals( expectedResult, actualResult);
    }

    @Test
    public void testMultiplyWithZeroAndFifteen(){

        int expectedResult = 0;
        int actualResult = sut.multiply(0, 15);
        assertEquals("0 times 15 is 0", expectedResult, actualResult);
    }
}
