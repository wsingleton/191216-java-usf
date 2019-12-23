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
  public void testSolutionWithValidArrayContainingSomePalindromes() {

    String[] testArray = {
            "alice",
            "racecar",
            "Do geese see God?",
            "Madam, I'm Adam.",
            "not a palindrome",
            "java",
            "kayak",
            "noon"
    };

    String[] expectedResult = {
            "racecar",
            "Do geese see God?",
            "Madam, I'm Adam.",
            "kayak",
            "noon"
    };

    assertArrayEquals(expectedResult, sut.filterPalindromes(testArray));

  }

  @Test
  public void testSolutionWithValidArrayContainingAllPalindromes() {

    String[] testArray = {
            "racecar",
            "Do geese see God?",
            "Madam, I'm Adam.",
            "kayak",
            "noon"
    };

    String[] expectedResult = {
            "racecar",
            "Do geese see God?",
            "Madam, I'm Adam.",
            "kayak",
            "noon"
    };

    assertArrayEquals(expectedResult, sut.filterPalindromes(testArray));

  }

  @Test
  public void testSolutionWithValidArrayContainingNoPalindromes() {

    String[] testArray = {
            "alice",
            "not a palindrome",
            "java",
            "blah",
            "test",
            "nope"
    };

    assertArrayEquals(new String[0], sut.filterPalindromes(testArray));

  }

  @Test
  public void testSolutionWithValidArrayContainingSomeNulls() {

    String[] testArray = {
            "alice",
            "racecar",
            "Do geese see God?",
            null,
            "not a palindrome",
            null,
            "kayak",
            "null"
    };

    String[] expectedResult = {
            "racecar",
            "Do geese see God?",
            "kayak",
    };

    assertArrayEquals(expectedResult, sut.filterPalindromes(testArray));

  }

  @Test
  public void testSolutionWithValidArrayContainingNumericPalindromes() {

    String[] testArray = {
            "alice",
            "11 00 11",
            "not a palindrome",
            "1234567",
            "p4ssw0rd dr0wss4p",
            "xP123 321Px"
    };

    String[] expectedResult = {
            "11 00 11",
            "p4ssw0rd dr0wss4p",
            "xP123 321Px"
    };

    assertArrayEquals(expectedResult, sut.filterPalindromes(testArray));

  }

  @Test
  public void testSolutionWithEmptyArray() {
    assertArrayEquals(new String[0], sut.filterPalindromes(new String[0]));
  }

  @Test
  public void testSolutionWithNullArray() {
    assertArrayEquals(new String[0], sut.filterPalindromes(null));
  }

}
