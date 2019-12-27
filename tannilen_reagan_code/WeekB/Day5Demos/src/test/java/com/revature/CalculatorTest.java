package com.revature;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator sut;

    @Before
    public void setup() {
        sut=new Calculator();
    }
    @After
    public void tearDown() {
        sut=null;
    }
    @Test
    public void multiplicationPositiveInputs() {
        int expected=15;
        int actual=sut.multiply(3,5);
        Assert.assertEquals("3*5=15", expected,actual);
    }
    @Test
    public void multiplicationMixedInputs() {
        int expected=-15;
        int actual=sut.multiply(3,-5);
        Assert.assertEquals("3*-5=-15",expected,actual);
    }
    @Test
    public void multiplicationNegativeInputs() {
        int expected=15;
        int actual=sut.multiply(-3,-5);
        Assert.assertEquals("-3*-5=15",expected,actual);
    }
    @Test
    public void multiplicationUsingZero() {
        int expected=0;
        int actual=sut.multiply(0, 5);
        Assert.assertEquals("0*n=0",expected,actual);
    }
}
