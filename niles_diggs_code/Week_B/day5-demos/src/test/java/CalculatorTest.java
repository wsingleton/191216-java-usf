import com.revature.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    private Calculator sut; // system under test

    @Before
    public void setUp() {
        sut = new Calculator(); //make a new instance and point to it
    }

    @After
    public void tearDown() {
        sut = null; // dereference the object after running the test
    }

    @Test
    public void testMultiplyWithThreeAndFive() {
        int expectedResult = 15;
        int actualResult = sut.multiply(3,5);
        Assert.assertEquals("3 times 5 is 15", expectedResult, actualResult);
    }

    @Test
    public void testMultiplyWithFiveAndThree() {
        int expectedResult = 15;
        int actualResult = sut.multiply(5, 3);
        Assert.assertEquals("5 times 3 is 15", expectedResult, actualResult);
    }

    @Test
    public void testMultiplyWithZeroAndFifteen() {
        int expectedResult = 0;
        int actualResult = sut.multiply(0, 15);
        Assert.assertThat(actualResult, is(expectedResult));
    }
}
