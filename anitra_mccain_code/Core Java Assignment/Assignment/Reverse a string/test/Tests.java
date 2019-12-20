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
  public void testSolutionUsingNullString() {
    assertEquals("The implementation should return an empty String if a null argument is provided",
            "", sut.reverse(""));
  }

  @Test
  public void testSolutionUsingEmptyString() {
    assertEquals("The implementation should return an empty String if an empty String argument is provided",
            "", sut.reverse(""));
  }

  @Test
  public void testSolutionUsingSimpleString() {
    assertEquals("The method is expected to reverse the provided String argument.",
            "tobor", sut.reverse("robot"));
  }

  @Test
  public void testSolutionUsingStringWithCapitalizedLetter() {
    assertEquals("The method is expected to reverse the provided String argument.",
            "nemaR", sut.reverse("Ramen"));
  }

  @Test
  public void testSolutionUsingStringWithPunctuationAndSpaces() {
    assertEquals("The method is expected to reverse the provided String argument.",
            "!yrgnuh m'I", sut.reverse("I'm hungry!"));
  }

  @Test
  public void testSolutionUsingPalindrome() {
    assertEquals("The method is expected to reverse the provided String argument.",
            "racecar", sut.reverse("racecar"));
  }

  @Test
  public void testSolutionUsingStringWithNewLines() {
    assertEquals("The method is expected to reverse the provided String argument.",
            "654\nfed\n321\ncba", sut.reverse("abc\n123\ndef\n456"));
  }

}