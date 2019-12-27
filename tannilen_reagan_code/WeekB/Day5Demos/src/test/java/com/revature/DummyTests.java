package com.revature;

import org.junit.*;

/*
    A class declaration that contains test methods is known as a test suite.
 */
public class DummyTests {
    /*
        JUnit annotations:
            @RunWith (class level)
            @BeforeClass (static method level)
            @AfterClass (static method level)
            @Before (instance method level)
            @After (instance method level)
            @Test (instance method level)
            @Ignore (instance method level)
            @Rule (instance field level)
     */
    @BeforeClass
    public static void testOfBeforeClass() {
        System.out.println("This will run one time before any of the test suite's test cases.  Can be thought of as a set-up method.  Must be static.");
    }
    @AfterClass
    public static void testOfAfterClass() {
        System.out.println("This will run one time after all of the test suite's test cases.  Can be thought of as a tear-down method. Must be static.");
    }
    @Before
    public void testOfBefore() {
        System.out.println("This will run prior to each individual test case in the test suite.  Can be thought of as a test initiation set-up.");
    }
    @After
    public void testOfAfter() {
        System.out.println("This will run after each individual test case in the test suite.  Can be thought of as a test completion clean-up.");
    }
    @Test
    public void testOfTest() {
        System.out.println("This is an individual test case within the test suite.  This one does nothing.");
    }
    @Test
    public void retestOfTest() {
        System.out.println("This is another test case within the test suite.  This one also does nothing.");
    }
    @Test
    public void testOfTestAgain() {
        System.out.println("This is a final test case within the test suite.  We still aren't doing anything.");
    }
    @Ignore("Test is simply a sample demonstration of the test of ignore.")
    public void testOfIgnore() {
        System.out.println("This test should not execute, as it is not yet ready to be tested.");
    }
}
