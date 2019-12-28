package com.revature;

import org.junit.*;

import java.io.FileNotFoundException;

/*
    A class declaration that includes test methods, is known as a "test suite".
    unit testing individual method-mocking up what it's supposed to return
    integration, how do things integrate with everything-behavior between two tests
 */
public class DummyTests {

    /*
        JUnit annotations

        -@RunWith (class-level) if you want your class to run with something specific
        -@BeforeClass (static method-level)
        -@AfterClass (static method-level
        -@Before (instance method-level)
        -@After (instance method-level)
        -@Test (instance method-level)
        -@Ignore (instance method-level)
        -@Rule (instance field-level)
     */

    @BeforeClass
    public static void runsBeforeClassTests(){
        System.out.println("This will run once before any of thetest suite's test cases.");
    }

    @AfterClass // this method MUST be declared as static
    public static void runsAfterClassTests(){
        System.out.println("This will run once after all of this test suite's test cases.");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("This will run once before each test case within the test suite.");
    }

    @After
    public void afterEachTest(){
        System.out.println("This will run once after each test case within the test suite.");
    }

    @Test
    public void testMyMethod(){
        System.out.println("This is a basic test method: this one doesn't actually test anything though.");
    }

    @Test
    public void testMyMethodAnotherWay() {
        System.out.println("This is another basic test method: this one doesn't actually test anything");
    }

    @Test(expected = FileNotFoundException.class)
    public void testMyOtherMethod() {
        System.out.println("This is yet another basic test method; this one doesn't actually test anything.");
    }

    @Ignore("test not finished, will come back to it")
    public void ignoreThisTest(){
        System.out.println("This test may not be finished, so we will ignroe it for now.");
    }



}
