package com.revature;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// to import static members of a class, we have to use import static syntax;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator sut; // sut stands for System Under test

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
        int actualResult = sut.multiply(1,15);
        assertEquals("0 times 15 is 0", expectedResult, actualResult);
    }
}
