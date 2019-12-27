package com.revature;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class SorterTest {
    private Sorter sut;
    @Rule
    public ExpectedException expectedException=ExpectedException.none();
    @Rule
    public Timeout globalTimeout=Timeout.seconds(5);
    @Before
    public void setup(){
        sut=new Sorter();
    }
    @After
    public void tearDown(){
        sut=null;
    }
    @Test
    public void testSolutionWithRandomArray() {
        String message="If a randomly ordered array is provided, the implementation should sort the array.";
        int[] testArray={1,11,-3,1,5,7,2,0,13};
        int[] expected={-3,0,1,1,2,5,7,11,13};
        int[] result=sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expected,result);
    }
    @Test
    public void testSolutionWithReversedArray() {
        String message="Array should sort properly even in worst case scenario.";
        int[] testArray={42,38,31,29,21,21,17,5};
        int[] expected={5,17,21,21,29,31,38,42};
        int[] result=sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expected,result);
    }
    @Test
    public void testSolutionEmptySet() {
        String message="An empty set should return an empty set.";
        int[] testArray=new int[0];
        int[] expected=new int[0];
        int[] result=sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expected,result);
    }
    @Test
    public void testSolutionWithPresortedArray() {
        String message="Presorted arrays should not be reordered.";
        int[] testArray={0,1,2,3,4,5};
        int[] expected={0,1,2,3,4,5};
        int[] result=sut.bubbleSorter(testArray);
        Assert.assertArrayEquals(message,expected,result);
    }
    @Test
    public void testSolutionWithNullInput() {
        String message="Null arrays should return an empty array.";
        int[] expected={};
        int[] result=sut.bubbleSorter(null);
        Assert.assertArrayEquals(message,expected,result);
    }
}
