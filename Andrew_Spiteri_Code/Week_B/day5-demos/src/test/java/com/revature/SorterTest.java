package com.revature;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class SorterTest {
    private Sorter sut;

    /*
        A JUnit rule is a component that intercepts test method calls and allows us
        to do something before a test method has run - typically adding additional
        constraints to the test case.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout  globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp(){
        sut = new Sorter();
    }
    @After
    public void tearDown(){
        sut = null;
    }
    @Test
    public void testSolutionWithRandomArray(){
        //Arrange
        String message = "If a randomly ordered array is provided the implementation should sort the array.";
        int[] testArray = {1, 11, -3, 5, 7, 2, 0, 13};
        int[] expectedResult = {-3, 0, 1, 2, 5, 7, 11, 13};
        //Act
        int[] actualResult = sut.bubbleSorter(testArray);
        //Assert
        Assert.assertArrayEquals(message,expectedResult,actualResult);
    }
    @Test
    public void testSolutionWithReverseArray(){

        int[] testArray = {13, 11, 7, 5, 3, 2, 1, 0 ,-3};
        int[] expectedResult = {-3, 0, 1, 2, 3, 5, 7, 11, 13};
        int[] actualResult = sut.bubbleSorter(testArray);
        String message = "If a reversed array is provided the implementation should sort the array " + actualResult;
        Assert.assertArrayEquals(message,expectedResult,actualResult);
    }
    @Test
    public void testSolutionWithPreSortedArray(){
        String message = "If a presorted array is provided the implementation should sort the array";
        int[] testArray = {-3, 0, 1, 2, 5, 7, 11, 13};
        int[] expectedResult = {-3, 0, 1, 2, 5, 7, 11, 13};
        int[] actualResult = sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expectedResult,actualResult);
    }
    @Test
    public void testSolutionWithEmptyArray(){
        String message = "If a empty array is provided the implementation should provide an empty array";
        int[] testArray = {};
        int[] expectedResult = {};
        int[] actualResult = sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expectedResult,actualResult);
    }
    @Test
    public void testSolutionWithNullArray(){
        String message = "If a null array is provided the implementation should provide an empty array";
        int[] testArray = null;
        int[] expectedResult = {};
        int[] actualResult = sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expectedResult,actualResult);
    }
}
