package com.revature;

import org.junit.*;

import java.io.FileNotFoundException;

//A class declaration that includes test methods is known as a "test suite"
public class DummyTest {
    /*
        JUnit annotations
            @RunWith (class-level)
            @BeforeClass (static method-level)
            @AfterClass (static method-level)
            @Before (instance method-level)
            @After (instance method-level)
            @Test (instance method-level)
            @Ignore (instance method-level)
            @Rule (instance field-level)
     */

    //need to be static; high-level set up
    @BeforeClass
    public static void runsBeforeClassTests(){
        System.out.println("This will run once before any of the test suite's test cases.");
    }
    //need to be static; high-level tear down
    @AfterClass
    public static void runsAfterClassTests(){
        System.out.println("This will run once after all of this test suite's test cases.");
    }
    @Before
    public void beforeEachTest(){
        System.out.println("This will run once before each test case within the test suite.");
    }
    @After
    public void afterEachTest(){
        System.out.println("This will run once after each test case within the test suite.");
    }
    @Test
    public void testMyMethod(){
        System.out.println("This is a basic test method; doesn't actually test anything, though");
    }
    @Test
    public void testMyMethodAnotherWay(){
        System.out.println("This is another basic test method; doesn't actually test anything, though");
    }
    @Test
    public void testMyOtherMethod(){
        System.out.println("This is another basic test method; doesn't actually test anything, though");
    }
    //Incomplete test, can pass String
    @Ignore("Test incomplete")
    public void ignoreThisTest(){
        System.out.println("This test may not be finished, so we will ignore it.");
    }

}
