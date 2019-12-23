import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

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
  public void testSolutionWithPrimeNumber() {
    assertTrue(sut.isPrime(13));
  }

  @Test
  public void testSolutionWithCompositeNumber() {
    assertFalse(sut.isPrime(26));
  }

  @Test
  public void testSolutionWithCarmichaelNumber() {
    assertFalse(sut.isPrime(561));
  }

  @Test
  public void testSolutionWithOne() {
    assertFalse(sut.isPrime(1));
  }

  @Test
  public void testSolutionWithZero() {
    assertFalse(sut.isPrime(0));
  }

  @Test
  public void testSolutionWithNegativeNumber() {
    assertFalse(sut.isPrime(-13));
  }

}