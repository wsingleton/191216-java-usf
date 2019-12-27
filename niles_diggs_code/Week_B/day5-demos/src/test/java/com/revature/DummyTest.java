package com.revature;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.junit.*;

import java.io.FileNotFoundException;

/*
    A class declaration that includes test methods, is known as a "test suite".
 */
public class DummyTest {

    /*
    JUnit annotations

        -@RunWith (class-level)
        -@BeforeClass (static method-level)
        -@AfterClass (static method-level)
        -@Before (instance method-level)
        -@After (instance method-level)
        -@Test (instance method-level)
        -@ignore(instance method-level)
        -@Rule (instance method-level)
     */

    // the following annotations must be declared as static or it will not run
    @BeforeClass
    public static void runsBeforeClassTests() {
        System.out.println("This will run once before any of the test suite's test cases.");
    }

    @AfterClass
    public static void runsAfterClassTests() {
        System.out.println("This will run once after all of the test suite's test cases.");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("This will run once before each test case within the test suite.");
    }

    @After
    public void afterEachTest() {
        System.out.println("THis will run once after each test case within the test suite");
    }

    @Test // you can have as many tests as you want
    public void testMyMethod() {
        System.out.println("This is a basic test method; this one doesn't actually test anything");
    }

    @Test
    public void testMyMethodAnotherWay() {
        System.out.println("This is another basic test method; this one doesn't actually test anything");

    }

    @Test(expected = FileNotFoundException.class) //included expectations for test running successfully
    public void testMyOtherMethod() {
        System.out.println("This is yet another basic test method; this one doesn't actually test anything");
    }

    @Ignore("unfinished test, will return later") //including reason for ignoring
    public void ignoreThisTest () {
        System.out.println("This test may not be finished, thus we will ignore it for now.");
    }



}
