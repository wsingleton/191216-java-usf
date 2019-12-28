package com.revature;

import org.junit.*;

/*
A class declaration that includes test method is know as a "test suite".
 */
public class DummyTest {

    /*
    JUnit annotations

    - @unWith (class-level)
    - @BeforeClass (static method-leve)
    - @AfterClass (static method level)
    - @Before (instance method-level)
    - @After (instance method-level)
    - @Ignore (instance method level)
    - @Rule (instance field level)

     */

    @BeforeClass // this method must be declared as static
    public static void runsBeforeClassTests(){
        System.out.println("this will run once before any of the test suite's test class");

    }

    @AfterClass // this method must be declared as static
    public static void runsAfterClassTest(){
        System.out.println("This will run after all of this test suite's test cases");
    }

    @Before
    public void beforeEachTest(){
        System.out.println("This will run once before each test case within the test suite");
    }

    @After()
    public void afterEachTest(){
        System.out.println("This will run once after each test case within the test suite");

    }

    @Test  // you can make many @test methods.
    public void testMyMethod(){
        System.out.println("This is a basic test method; this doesn't actually test anything though");
    }

    @Test // once you add parenthisis (), you can point the cursor inside the () and click on control + backspace, the parameters suggestion will pop up.
    public void testMyMethodAnotherWay(){
        System.out.println("This is another basic test method; this doesn't actually test anything though");
    }

    @Ignore("test not finished, will come back to it") // it's possible to pass arguments to annotations.
    public void ignoreThisTest(){
        System.out.println("This test  may not be finished, so we will ignore it for now.");
    }
}
