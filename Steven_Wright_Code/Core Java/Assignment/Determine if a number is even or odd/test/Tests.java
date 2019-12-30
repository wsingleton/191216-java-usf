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
  public void testSolutionWithEvenNumber() {
    System.out.println("DO YOU EVEN PRINT?!");
    String expectedResult = "even";
    String actualResult = sut.isEvenOrOdd(42);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithOddNumber() {
    String expectedResult = "odd";
    String actualResult = sut.isEvenOrOdd(93);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithEvenNegativeNumber() {
    String expectedResult = "even";
    String actualResult = sut.isEvenOrOdd(-24);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithOddNegativeNumber() {
    String expectedResult = "odd";
    String actualResult = sut.isEvenOrOdd(-19);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithZero() {
    String expectedResult = "even";
    String actualResult = sut.isEvenOrOdd(0);
    assertEquals(expectedResult, actualResult);
  }

}