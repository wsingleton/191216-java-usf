package com.revature;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class SorterTest {

    private Sorter sut;

    //none of the test will throw an exception rule, if it does then it will fail
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

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
        //arrange
        String message = "If a randomly ordered array is provided the implementation should sort here";
        int[] testArray = {13,2,3,4,5};
        int[] expectedResult = { 2,3,4,5,13};

        //act
        int[] actualResult = sut.bubbleSorter(testArray);

        //assert
        Assert.assertArrayEquals(message, expectedResult,actualResult);
    }
    //test don't take in parameters
    @Test
    public void testSolutionWithAReverseArray(){
        //arrange
        String message = "If a reverse array is provided the implementation should sort here";
        int[] testArray = {13,11,7,5,3,2};
        int[] expectedResult = { 2,3,5,7,11,13};

        //act
        int[] actualResult = sut.bubbleSorter(testArray);

        //assert
        Assert.assertArrayEquals(message, expectedResult,actualResult);
    }

    @Test
    public void testSolutionWithPresortedArray(){
        //arrange
        String message = "If a presorted array is provided the implementation should sort here";
        int[] testArray = {2,3,4,5,6,7};
        int[] expectedResult = {2,3,4,5,6,7};

        //act
        int[] actualResult = sut.bubbleSorter(testArray);

        //assert
        Assert.assertArrayEquals(message, expectedResult,actualResult);
    }

    @Test
    public void testSolutionWithEmptyArray(){
        //arrange
        String message = "If an empty array is provided return empty array";
        int[] testArray = {};
        int[] expectedResult = {};

        //act
        int[] actualResult = sut.bubbleSorter(testArray);

        //assert
        Assert.assertArrayEquals(message, expectedResult,actualResult);
    }

    @Test
    public void testSolutionWithNullArray(){
        //arrange
        String message = "If a null object is provided return empty array";
        int[] testArray = null;
        int[] expectedResult = {};

        //act
        int[] actualResult = sut.bubbleSorter(testArray);

        //assert
        Assert.assertArrayEquals(message, expectedResult,actualResult);
    }
}
