import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Tests {

  private Task sut;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3);

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    sut = new Task();
  }

  @After
  public void tearDown() {
    sut = null;
  }

  @Test
  public void testSolutionWithValidStringAndValidBoundaries() {
    String expectedResult = "test";
    String actualResult = sut.substring("This is a test string.", 10, 14);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidStringAndNegativeBoundaries() {
    String expectedResult = "";
    String actualResult = sut.substring("This is a test string.", -1, -1);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidStringAndNegativeStart() {
    String expectedResult = "";
    String actualResult = sut.substring("This is a test string.", -1, 14);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidStringAndEndLessThanStart() {
    String expectedResult = "";
    String actualResult = sut.substring("This is a test string.", 14, 10);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithEmptyStringAndValidBoundaries() {
    String expectedResult = "";
    String actualResult = sut.substring("", 10, 14);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithNullStringAndValidBoundaries() {
    String expectedResult = "";
    String actualResult = sut.substring(null, 10, 14);
    assertEquals(expectedResult, actualResult);
  }

}