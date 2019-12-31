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
  public void testSolutionWithValidValues() {
    assertEquals(1161.62, sut.calculateInterest(1000, 5, 0.03, 12), 0);
  }

  @Test
  public void testSolutionWithNegativePrincipal() {
    assertEquals(0, sut.calculateInterest(-1000, 5, 0.03, 12), 0);
  }

  @Test
  public void testSolutionWithNegativeRate() {
    assertEquals(0, sut.calculateInterest(1000, 5, -0.03, 12), 0);
  }

  @Test
  public void testSolutionWithNegativeTime() {
    assertEquals(0, sut.calculateInterest(1000, -5, 0.03, 12), 0);
  }

  @Test
  public void testSolutionWithNegativeFrequency() {
    assertEquals(0, sut.calculateInterest(1000, 5, 0.03, -12), 0);
  }

}