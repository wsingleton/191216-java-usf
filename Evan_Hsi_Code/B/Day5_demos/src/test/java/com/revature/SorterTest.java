package com.revature;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertArrayEquals;

public class SorterTest {

    private Sorter sut;

    /*
        A JUnit rule is a component that intercepts test method calls and allows us to do
        something before a test method has run - typically adding additional constraints.
     */

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp() {
        sut = new Sorter();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testSolutionWithRandomArray() {

        // Arrange
        String message = "If a randomly ordered array is provided, the implementation should sort the array.";
        int[] testArray = { 1, 11, -3, 1, 5, 7, 2, 0, 13 };
        int[] expectedResult = { -3, 0, 1, 1, 2, 5, 7, 11, 13 };

        // Act
        int[] actualResult = sut.bubbleSorter(testArray);

        // Assert
        assertArrayEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testSolutionWithReversedArray() {

        // Arrange
        String message = "If a reverse ordered array is provided, the implementation should sort the array.";
        int[] testArray = { 5, 4, 3, 2, 1, 0, -1 };
        int[] expectedResult = { -1, 0, 1, 2, 3, 4, 5 };

        // Act
        int[] actualResult = sut.bubbleSorter(testArray);

        // Assert
        assertArrayEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testSolutionWithPresortedArray() {
        String message = "If a presorted array is provided, the implementation should sort the array.";
        int[] testArray = { 2, 3, 5, 7, 11, 13 };
        int[] expectedResult = { 2, 3, 5, 7, 11, 13 };
        int[] actualResult = sut.bubbleSorter(testArray);
        assertArrayEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testSolutionWithPresorted() {
        String message = "If an empty array is provided, return the empty array.";
        int[] testArray = {};
        int[] expectedResult = {};
        int[] actualResult = sut.bubbleSorter(testArray);
        assertArrayEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testSolutionWithNull() {
        String message = "If null is passed, return empty array.";
        int[] testArray = null;
        int[] expectedResult = {};
        int[] actualResult = sut.bubbleSorter(testArray);
        assertArrayEquals(message, expectedResult, actualResult);
    }


}
