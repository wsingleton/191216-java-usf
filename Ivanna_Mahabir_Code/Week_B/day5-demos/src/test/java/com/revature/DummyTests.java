package com.revature;

import org.junit.*;

import java.io.FileNotFoundException;

/*
    A class declaration that includes test method, is known as a "test suite".
 */
public class DummyTests {

    /*
        JUnit annotations

        - @RunWith (class-level)
        - @BeforeClass (static method-level)
        - @AfterClass (static method-level)
        - @Before (instance method-level)
        - @After (instance method-level)
        - @Test (instance method-level)
        - @Ignore (instance method-level)
        - @Rule (instance field-level)

     */

    @BeforeClass // this method MUST be declared as static
    public static void runsBeforeClassTests(){
        System.out.println("This will run once before any of the test suite's cases.");
    }

    @AfterClass // this method MUST be declared as static
    public static void runsAfterClassTests(){
        System.out.println("This will run once after all of this test suite's cases");
    }

    @Before
    public void beforeEachTest(){
        System.out.println("This will run once before each test case within the test suite");
    }

    @After
    public void afterEachTest(){
        System.out.println("This will run once after each test case within the test suite");
    }

    @Test
    public void testMyMethod() {
        System.out.println("This is a basic test method; this one doesn't actually test anything though");
    }

    @Test
    public void testMyMethodAnotherWay(){
        System.out.println("This is another test basic test method");
    }

    @Test(expected = FileNotFoundException.class)
    public void testMyOtherMethod(){
        System.out.println("THis is yet another basic test method;");
    }

    @Ignore ("test not finished, will come back to it")
    public void ignoreThisTest(){
        System.out.println("This test may not be finished, so we ignore it for now");
    }


}
