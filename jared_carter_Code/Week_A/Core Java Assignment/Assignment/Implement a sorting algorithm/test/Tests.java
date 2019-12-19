import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertArrayEquals;

public class Tests {

  private Task sut;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3);

  @Before
  public void setUp() {
    sut = new Task();
  }

  @After
  public void tearDown() {
    sut = null;
  }

  @Test
  public void testSolutionWithRandomArray() {
    String message = "If a randomly sorted array is provided, the implementation should return an empty array";
    int[] testArray = {1, 11, -3, 1, 5, 7, 2, 0, 3, 13};
    int[] expectedArray = {-3, 0, 1, 1, 2, 3, 5, 7, 11, 13 };
    assertArrayEquals(message, expectedArray, sut.sortNumbers(testArray));
  }

  @Test
  public void testSolutionWithReversedArray() {
    String message = "If a reversed array is provided, the implementation should return a sorted array";
    int[] testArray = {13, 11, 7, 5, 3, 2, 1, 1, 0, -3 };
    int[] expectedArray = {-3, 0, 1, 1, 2, 3, 5, 7, 11, 13 };
    assertArrayEquals(message, expectedArray, sut.sortNumbers(testArray));
  }

  @Test
  public void testSolutionWithPresortedArray() {
    String message = "If a presorted array is provided, the implementation should return the presorted array";
    int[] testArray = {-3, 0, 1, 1, 2, 3, 5, 7, 11, 13 };
    int[] expectedArray = {-3, 0, 1, 1, 2, 3, 5, 7, 11, 13 };
    assertArrayEquals(message, expectedArray, sut.sortNumbers(testArray));
  }

  @Test
  public void testSolutionWithEmptyArray() {
    String message = "If an empty array is provided, the implementation should return an empty array";
    int[] testArray = {};
    int[] expectedArray = {};
    assertArrayEquals(message, expectedArray, sut.sortNumbers(testArray));
  }

  @Test
  public void testSolutionWithNullArray() {
    String message = "If a null array is provided, the implementation should return an empty array";
    int[] expectedArray = {};
    assertArrayEquals(message, expectedArray, sut.sortNumbers(null));
  }

}