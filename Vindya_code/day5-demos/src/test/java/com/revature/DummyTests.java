package com.revature;
/*
A class declaration that includes test method is known as a "test suit".
 */


import org.junit.*;

public class DummyTests {

    /* Junit annotations
    -@Runwith (class-level)
    -@BeforeClass (static method-level)
    -@AfterClass(static method_level)
    -@Before (instance-method level)
    -After (instance method-level)
    =@Test (instance method-level)
    @Ignore (instance method-level)
    @Rule (instance field-level)

     */
    @BeforeClass
    public static void runBeforeClass() {
        System.out.println("This will run once before any of the test suite's test cases");

    }
@AfterClassmain
public static void runsAfterClassTests() {
        System.out.println("This will run once before any of the test suite's test cases");

    }
    @Before
    public static void beforeEachTest() {
        System.out.println("This will run once before each test case within the test suite");
    }
    @After
    public void afterEachTest(){
        System.out.println("This will run once after each test case within th etest suite");

        @Test
        public void testMyMethod(){
            System.out.println("This is a basic test method; this one doesn't actually test anything though");


    }
    @Test(expected = FileNotFoundException.class);
            public void testMyOtherMethod() {
            System.out.println("This is yet another basic method; this one doesn't actually test anything");

            }

            @Ignore("test not finished, will come back to it");
            public void ignoreThisTest () {
                System.out.println("This test may not be finished, so we will ignore it for now.");
            }

        }


            }
        }
