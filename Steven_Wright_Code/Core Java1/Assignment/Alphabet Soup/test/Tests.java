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
  public void testSolutionUsingSimplePhrase() {
    final String phrase = "Simple Object Access Protocol";
    final String expected = "SOAP";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

  @Test
  public void testSolutionUsingPhraseWithPunctuation() {
    final String phrase = "First In, First Out";
    final String expected = "FIFO";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

  @Test
  public void testSolutionUsingPhraseWithAcronym() {
    final String phrase = "YAML Ain't Markup Language";
    final String expected = "YAML";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

  @Test
  public void testSolutionUsingPhraseWithHyphenatedWord() {
    final String phrase = "Complementary metal-oxide semiconductor";
    final String expected = "CMOS";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

  @Test
  public void testSolutionUsingEmptyPhrase() {
    final String phrase = "";
    final String expected = "";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

  @Test
  public void testSolutionUsingNullPhrase() {
    final String expected = "";
    assertEquals(expected, sut.createAcronymFromPhrase(null));
  }

  @Test
  public void testSolutionUsingOnlyWhiteSpace() {
    final String phrase = "                 ";
    final String expected = "";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

  @Test
  public void testSolutionUsingPhraseWithExcessWhiteSpace() {
    final String phrase = "    The   quick brown fox  jumped over the lazy  dog    ";
    final String expected = "TQBFJOTLD";
    assertEquals(expected, sut.createAcronymFromPhrase(phrase));
  }

}