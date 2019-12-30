import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

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
  public void ensureNoOverloading() {
    Method[] classMethods = Task.class.getDeclaredMethods();
    assertEquals(1, classMethods.length);
    assertEquals("genericPrinter", classMethods[0].getName());
  }

  @Test
  public void testSolutionWithStrings() {

    sut.genericPrinter("test-1", "test-2", "test-3", "test-4");
    assertThat(outContent.toString(), containsString("test-1"));
    assertThat(outContent.toString(), containsString("test-2"));
    assertThat(outContent.toString(), containsString("test-3"));
    assertThat(outContent.toString(), containsString("test-4"));

  }

  @Test
  public void testSolutionWithIntegers() {

    sut.genericPrinter(93, 418, 777, 7861);
    assertThat(outContent.toString(), containsString("93"));
    assertThat(outContent.toString(), containsString("418"));
    assertThat(outContent.toString(), containsString("777"));
    assertThat(outContent.toString(), containsString("7861"));

  }

}