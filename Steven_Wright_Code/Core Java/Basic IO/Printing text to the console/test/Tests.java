import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Tests {

  private Task sut;

  private PrintStream sysOut;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3);

  @Before
  public void setUp() {
    sut = new Task();
    sysOut = System.out;
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() {
    sut = null;
    System.setOut(sysOut);
  }

  @Test
  public void testSolution() {
    sut.sayHello();
    assertThat("Output should be \"Hello, world!\", exactly.",
            outContent.toString(), containsString("Hello, world!"));
  }

}