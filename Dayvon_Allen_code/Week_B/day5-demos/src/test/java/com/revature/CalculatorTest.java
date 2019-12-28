package com.revature;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator sut;

    @Before
    public void setUp(){
        sut = new Calculator();
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testMultipleWithThreeAndFive() {
        int expectedResult = 15;
        int actualResult = sut.multiply(3,5);
        //assert what should happen
        Assert.assertEquals("3 times 5 is 15",expectedResult, actualResult);
    }

    @Test
    public void testMultipleWithFiveAndThree() {
        int expectedResult = 15;
        int actualResult = sut.multiply(3,5);
        //assert what should happen
        Assert.assertEquals("3 times 5 is 15",expectedResult, actualResult);
    }

    @Test
    public void testMultipleWithZeroAndThree() {
        int expectedResult = 0;
        int actualResult = sut.multiply(3,0);
        //assert what should happen
        Assert.assertEquals("3 times 0 is 0",expectedResult, actualResult);
    }
}
