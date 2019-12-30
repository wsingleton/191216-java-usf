package com.revature;

import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.*; //import all the static methods
import static org.junit.Assert.assertEquals;
public class CalculatorTest {

    private Calculator sut;

    @Before
    public void setUp(){
        sut = new Calculator();    //creates a new obj, so there is no related/inherited behaviour
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testMultiplyWithThreeAndFive(){
        int expectedResult = 15;
        int actualResult = sut.multiply(3, 5);
        assertEquals("3 times 5 is 15", expectedResult, actualResult);
    }

    @Test
    public void testMultiplyWithFiveAndThree(){
        int expectedResult = 15;
        int actualResult = sut.multiply(5, 3);
        assertEquals("3 times 5 is 15", expectedResult, actualResult);
    }

    @Test
    public void testMultiplyWithZeroAndFifteen(){
        int expectedResult = 0;
        int actualResult = sut.multiply(0, 15);
        assertEquals("0 times 15 is 0", expectedResult, actualResult);
    }
}
