package com.revature;

import org.junit.*;
/*
    A class declaration that includes test methods, is known as a "test Suite".
 */
public class DummyTest {

    /*
        JUnit annotation
            - @RunWith (class-level)
            - @BeforeClass (static method-level)
            - @AfterClass ( static method-level)
            - @Before (instance method-level)
            - @After (instance method-level)
            - @Ignore (instance method-level)
            - @Rule (instance method-level)
     */
    @BeforeClass
    public static void runsBeforeClassTest() {
        System.out.println("This will run once before any of the test suite's test case.");
    }

    @AfterClass
    public static void runsAfterClassTest() {
        System.out.println("This will run once after all of this test suite's test cases.");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("This will run once before each test case within the test suite");
    }

    @After
    public void afterEachTest() {
        System.out.println("This will run once before each test case within the test suite");
    }

    @Test
    public void testMyMethod() {
        System.out.println("This is a basic test method; this one doesn't test anything though");
    }

    @Test
    public void testMyOtherMethod() {
        System.out.println("This is yet another besic test method; this one doesnt test either");
    }

    @Ignore
    public void ignoreThisTest() {
        System.out.println("This test may not be finished so you will ignore it for now");
    }

}




