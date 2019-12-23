import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Tests {

  private Task sut;
  private InputStream sysIn = System.in;

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
    System.setIn(sysIn);
  }

  @Test
  public void testSolutionWithNumericInput() {
    System.setIn(new ByteArrayInputStream("42".getBytes()));

    assertEquals("The implementation did not retrieve input from the user correctly.",
            sut.getIntegerFromUser(), 42);

    assertNotNull("The Scanner member cannot be null!", sut.consoleScanner);


  }

  @Test
  public void testThatSolutionWithNonNumericInput() {
    System.setIn(new ByteArrayInputStream("test".getBytes()));
    sut.getIntegerFromUser();
    assertNotNull("The Scanner member cannot be null!", sut.consoleScanner);
  }

}
