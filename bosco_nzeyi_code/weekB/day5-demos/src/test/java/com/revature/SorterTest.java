package com.revature;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class SorterTest {

    private Sort sut;
    public int [] myArr;

    /*
    A JUnit rule is a component that intercepts test method calls and allows us
    to do something before a test method has run - typically adding additional constraints to the test case.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp(){
        sut = new Sort();
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testSolutionWithRandomArray(){
        String message = "if a randomly ordered array is provided, the implementation should sort the array ";
        int [] testArray = {1, 11, -3, 5, 7, 2, 0, 13};
        int [] expectedResult = {-3, 0, 1, 2, 5, 7, 11, 13};

        //Act
        int [] actualResult = sut.bubbleSorter(testArray);

        myArr = actualResult;

        // Assert
        Assert.assertArrayEquals(message, expectedResult, actualResult);
        printResults();

    }

    public void printResults(){
        for(int i: myArr){
            System.out.println(i);
        }
    }


//    @Test
//    public void testSolutionWithReversedArray(){
//        String message = "if reversed array is provided, tthe implementation should sort the array ";
//        int [] testArray = {};
//    }
}
