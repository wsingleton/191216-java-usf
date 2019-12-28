package com.revature;

import org.junit.*;

/*
a class declaration that includes test methods is known as a "test suite".
unit testing individual methods
integration testing, how do things work with one another
 */
public class DummyTest {

    /*

    Junit annotations

        - @RunWith (class-level)
        - @beforeClass (static method-level)
        - @AfterClass (static method level)
        - @Before (instance method-level)
        - @After (instance method-level)
        - @Test (instance method-level)
        - @Ignore (instance method-level)
        - @Rule (instance field-level)
     */

    //runs one time(high level set up)
    @BeforeClass
    public static void runsBeforeClassTests(){
        System.out.println("This will run once before any of the other test suite's test cases.");
    }

    //runs one time(high level tear down)
    @AfterClass
    public static void runsAfterClassTests(){
        System.out.println("This will run once after any of the other test suite's test cases.");
    }

    //instance methods, setup stuff
    @Before
    public void beforeEachTest(){
        System.out.println("set up.");
    }

    //tears down stuff
    @After
    public void afterEachTest(){
        System.out.println("tear down");
    }

    @Test
    public void testMyMethod(){
        System.out.println("This is a basic test method; this one doesn't actually test anything though.");
    }

    @Test
    public void testMyMethodAnotherWay(){
        System.out.println("This is another basic test method; this one doesn't actually test anything though.");
    }

    @Test()
    public void testMyOtherMethod(){
        System.out.println("This is yet another basic test method; this one doesn't actually test anything though.");
    }

    //ignores test while working on another one
    @Ignore("is not finished, will come back to it.")
    public void ignoreThisTest(){
        System.out.println("This test may not be finish, so we will ignore it for now.");
    }

}
