import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

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
  public void testSolutionWithValidStringContainingSpaces() {
    String testString = "the quick brown fox jumped over the lazy dog";
    String expectedResult = "thequickbrownfoxjumpedoverthelazydog";
    String actualResult = sut.collapseWhiteSpace(testString);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidStringContainingExcessiveSpaces() {
    String testString = "   the   quick  brown fox     jumped over the   lazy dog    ";
    String expectedResult = "thequickbrownfoxjumpedoverthelazydog";
    String actualResult = sut.collapseWhiteSpace(testString);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidStringContainingNoSpaces() {
    String testString = "no-spaces-here!";
    String expectedResult = testString;
    String actualResult = sut.collapseWhiteSpace(testString);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSolutionWithValidStringContainingOnlySpaces() {
    String testString = "                 ";
    assertEquals("", sut.collapseWhiteSpace(testString));
  }

  @Test
  public void testSolutionWithEmptyString() {
    assertEquals("", sut.collapseWhiteSpace(""));
  }

  @Test
  public void testSolutionWithNullString() {
    assertEquals("", sut.collapseWhiteSpace(null));
  }

}