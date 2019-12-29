package com.revature;

import org.junit.*;

/*
    A class declaration that includes test methods is know as a "test suite"
 */
public class DummyTests {

    /*
        Junit Annotations

            - @RunWith (class-level)
            - @BEFORECLASS (STATIC METHOD-level)
            - @AfterClass (Static method-level)
            - @Before (Instance method-level)
            - @After (Instance method-level)
            - @Test (Instance method-level)
            - @Ignore (Instance method-level)
            - @Rule (instance field level)
     */

    @BeforeClass
    public static void runsBeforeClass() {
        System.out.println("This will run once before any of the test suite's test cases.");
    }

    @AfterClass
    public static void runsAfterClass() {
        System.out.println("This will run once after all of this test suite's test cases.");
    }

    @Before
    public void beforeInstance() {
        System.out.println("This will run once before each test case within the test suite.");
    }

    @After
    public void afterInstance() {
        System.out.println("This will run once after each test case within the test suite.");
    }

    @Test
    public void testMyMethod() {
        System.out.println("This is a basic test method, this one doesn't actually test anything though.");
    }

    @Test
    public void testMyMethod2() {
        System.out.println("Another test method.");
    }

    @Ignore
    public void ignoreThisTest() {
        System.out.println("This test may not be finished so we will ignore it");
    }

}
