import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.File;
import java.util.Map;

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
  public void testExtractTextWithExistingFileContainingText() {
    String[] expectedResult = new String[] {
      "the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"
    };

    String[] actualResult = sut.extractTextFromFile(new File("resources/has-text.txt"));
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void testExtractTextWithExistingEmptyFile() {
    String[] actualResult = sut.extractTextFromFile(new File("resources/empty.txt"));
    assertEquals(0L, actualResult.length);
  }

  @Test
  public void testExtractTextWithNullFile() {
    String[] actualResult = sut.extractTextFromFile(null);
    assertEquals(0L, actualResult.length);
  }

  @Test
  public void testExtractTextWithMissingFile() {
    String[] actualResult = sut.extractTextFromFile(new File("resources/missing.txt"));
    assertEquals(0L, actualResult.length);
  }

  @Test
  public void testCountWordsWithValidStringArray() {
    Map<String, Integer> actualResult = sut.countWords(new String[] {
      "a", "b", "c", "d", "a", "b", "c", "d", "aa", "bb", "cc",
      "aaa", "bbb", "A", "B", "C", "D", "A", "B", "CC", "DDD"
    });

    assertEquals(2, (long) actualResult.get("a"));
    assertEquals(2, (long) actualResult.get("b"));
    assertEquals(2, (long) actualResult.get("c"));
    assertEquals(2, (long) actualResult.get("d"));
    assertEquals(1, (long) actualResult.get("aa"));
    assertEquals(1, (long) actualResult.get("bb"));
    assertEquals(1, (long) actualResult.get("cc"));
    assertEquals(1, (long) actualResult.get("aaa"));
    assertEquals(1, (long) actualResult.get("bbb"));
    assertEquals(2, (long) actualResult.get("A"));
    assertEquals(2, (long) actualResult.get("B"));
    assertEquals(1, (long) actualResult.get("C"));
    assertEquals(1, (long) actualResult.get("D"));
    assertEquals(1, (long) actualResult.get("CC"));
    assertEquals(1, (long) actualResult.get("DDD"));

  }

  @Test
  public void testCountWordsWithEmptyStringArray() {
    Map<String, Integer> actualResult = sut.countWords(new String[0]);
    assertTrue(actualResult.isEmpty());
  }

  @Test
  public void testCountWordsWithNullStringArray() {
    Map<String, Integer> actualResult = sut.countWords(null);
    assertTrue(actualResult.isEmpty());
  }

}
