package com.revature;

public class SorterTest {
    private Sorter sut;


    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Rule
    public Timeout globalTimeOut = Timeout.seconds(5);

    @Before
    public void setUp(){
        sut = new sorter();

        @After
                piublic void tearDown() {
            sut = null;
        }

        }
    @ Test

public void testSolutionWithRandomArray(){
    String message ="If a randomly array is provided, the implementation should sort the array "}
    int[] testArray = {1,11,-3,1,5,7,2,0,13};
    int[] expectedResult = {-3, 0, 1,1,2,5,7,11,13};
    //Act
    int[] actualResult = sut.bubbleSorter(testArray);
    //Assert
    assertArrayEquals(message, expectedResult, actualResult);


}
@Test
public void testSolutionWithReversedArray(){
    String message = "If a reversed array is provided, the implementation should sort the array"}

}
for(int i = 0; i<)



