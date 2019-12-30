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
  public void testSolutionWithValidArray() {

    int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    String[] expectedResult =
          {
            "1", "2", "fizz", "4", "buzz",
            "fizz", "7", "8", "fizz", "buzz",
            "11", "fizz", "13", "14", "fizzbuzz"
          };

    String[] actualResult = sut.fizzBuzz(testArray);
    assertArrayEquals(expectedResult, actualResult);

  }

  @Test
  public void testSolutionWithEmptyArray() {
    assertArrayEquals(new String[0], sut.fizzBuzz(new int[0]));
  }

  @Test
  public void testSolutionWithNullArray() {
    assertArrayEquals(new String[0], sut.fizzBuzz(null));
  }

}