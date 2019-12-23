import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Tests {

  private Task sut;
  private InputStream sysIn = System.in;
  private final ByteArrayInputStream inContent = new ByteArrayInputStream("test".getBytes());

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3);

  @Before
  public void setUp() {
    sut = new Task();
    System.setIn(inContent);
  }

  @After
  public void tearDown() {
    sut = null;
    System.setIn(sysIn);
  }

  @Test
  public void testSolution() {
    assertThat("The implementation did not retrieve input from the user correctly.",
            sut.getStringFromUser(), equalTo("test"));
    assertNotNull("The BufferedReader member cannot be null!", sut.consoleReader);
  }

}
