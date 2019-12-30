import org.junit.*;
import org.junit.rules.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    try {
      File fileForDeletion = new File("resources/write.txt");
      if (fileForDeletion.exists()) Files.delete(Paths.get(fileForDeletion.getPath()));
    } catch (Exception e) {
      System.err.println("Something went wrong while attempting to delete the file.");
    }

  }

  @Test
  public void testSolutionWithValidArray() {
    String[] validLines = {
            "This is test line 1",
            "This is test line 2",
            "This is test line 3",
            "This is test line 4",
            "This is test line 5"
    };

    sut.writeToFile(validLines);

    File expectedFile = new File("resources/write.txt");
    assertTrue("The expected file, write.txt, does not exist.", expectedFile.exists());

    String[] resultingLines = readSolutionFile();

    assertArrayEquals("The implementation did not write to the file correctly.", validLines, resultingLines);

  }

  @Test
  public void testSolutionWithEmptyArray() {
    String[] emptyLines = {};

    sut.writeToFile(emptyLines);

    File expectedFile = new File("resources/write.txt");
    assertTrue("The expected file, write.txt, does not exist.", expectedFile.exists());

    String[] resultingLines = readSolutionFile();

    assertArrayEquals("The implementation did not write to the file correctly.", emptyLines, resultingLines);

  }

  @Test
  public void testSolutionWithNullArray() {

    sut.writeToFile(null);
    File shouldNotExist = new File("resources/write.txt");
    assertFalse(shouldNotExist.exists());

  }

  private String[] readSolutionFile() {
    ArrayList<String> lineList = new ArrayList<>();
    Path filePath = Paths.get("resources/write.txt");

    try {
      Files.lines(filePath).forEach(lineList::add);
    } catch (Exception e) {
      fail();
    }


    String[] lineArray = new String[lineList.size()];
    for(int i = 0; i < lineArray.length; i++) lineArray[i] = lineList.get(i);
    return lineArray;
  }

}