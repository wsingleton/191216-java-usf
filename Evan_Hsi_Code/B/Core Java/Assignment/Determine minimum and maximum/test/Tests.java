import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

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
  public void testSolutionWithValidArrayOfRandomNumbers() {
    int[] testArray = { 3, 12, -3, 0, 93, 92, 22, 14, 1, 3, -3 };
    int[] expectedResult = { -3, 93 };
    int[] actualResult = sut.determineMinAndMax(testArray);
    assertEquals(2, actualResult.length);
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidArrayContainingDuplicatedNumber() {
    int[] testArray = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
    int[] expectedResult = { 3, 3 };
    int[] actualResult = sut.determineMinAndMax(testArray);
    assertEquals(2, actualResult.length);
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidArrayContainingOneNumber() {
    int[] testArray = { 93 };
    int[] expectedResult = { 93, 93 };
    int[] actualResult = sut.determineMinAndMax(testArray);
    assertEquals(2, actualResult.length);
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithEmptyArray() {
    assertArrayEquals(new int[0], sut.determineMinAndMax(new int[0]));
  }

  @Test
  public void testSolutionWithNullArray() {
    assertArrayEquals(new int[0], sut.determineMinAndMax(null));
  }

}