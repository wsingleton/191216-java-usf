import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class Tests {

  private Task sut;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3);

  @After
  public void tearDown() {
    sut = null;
  }

  @Test
  public void testSize() {
    sut = new Task(10);
    assertEquals(sut.elements.length, sut.size());
  }

  @Test
  public void testPush() {
    sut = new Task();
    sut.push("test-1");
    sut.push("test-2");
    sut.push("test-3");
    assertEquals(0, Arrays.binarySearch(sut.elements, "test-1"));
    assertEquals(1, Arrays.binarySearch(sut.elements, "test-2"));
    assertEquals(2, Arrays.binarySearch(sut.elements, "test-3"));
  }

  @Test
  public void testPopWhenStackIsPopulated() {
    sut = new Task();
    sut.push("test-1");
    sut.push("test-2");
    sut.push("test-3");
    String expectedResult = "test-3";
    String actualResult = sut.pop();
    assertEquals(expectedResult, actualResult);
    assertNull(sut.elements[2]);
  }

  @Test
  public void testPeekWhenStackIsPopulated() {
    sut = new Task();
    sut.push("test-1");
    sut.push("test-2");
    sut.push("test-3");
    String expectedResult = "test-3";
    String actualResult = sut.peek();
    assertEquals(expectedResult, actualResult);
    assertEquals(expectedResult, sut.elements[2]);
  }

  @Test(expected = EmptyStackException.class)
  public void testPopWhenStackIsEmpty() {
    sut = new Task();
    sut.pop();
  }

  @Test(expected = EmptyStackException.class)
  public void testPeekWhenStackIsEmpty() {
    sut = new Task();
    sut.peek();
  }

}