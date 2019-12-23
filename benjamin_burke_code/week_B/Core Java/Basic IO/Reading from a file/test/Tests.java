import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;
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
  public void testSolutionWithValidTestFile() {

    String[] expectedResult = {
                                "This is test line 1.",
                                "This is test line 2.",
                                "This is test line 3.",
                                "This is test line 4."
                              };

    File testFile = new File("resources/test.txt");
    assertArrayEquals(expectedResult, sut.getLines(testFile));

  }

  @Test
  public void testSolutionWithEmptyFile() {
    File emptyFile = new File("resources/empty.txt");
    assertArrayEquals("An empty array is expected if the source text file is empty.",
            new String[0], sut.getLines(emptyFile));
  }

  @Test
  public void testSolutionWithNonExistentFile() {
    File nonFile = new File("resources/fake-file.txt");
    assertArrayEquals("An empty array is expected if the source text file does not exist.",
            new String[0], sut.getLines(nonFile));
  }

  @Test
  public void testSolutionWithNullFile() {
    assertArrayEquals("An empty array is expected if provided File argument is null.",
            new String[0], sut.getLines(null));
  }

}
