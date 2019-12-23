import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeComparatorTest {

    private EmployeeComparator sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setUp() {
        sut = new EmployeeComparator();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testIfComparatorIsImplemented() {
        assertTrue(sut instanceof Comparator);
    }

    @Test
    public void testCompareWithValidEmployeesFirstArgSalaryIsGreater() {
        Employee e1 = new Employee(1, "alice", "anderson", 90000d);
        Employee e2 = new Employee(2, "bob", "bailey", 80000d);
        assertEquals("Should return 1 if the first argument is \"greater\"",1, sut.compare(e1, e2));
    }

    @Test
    public void testCompareWithValidEmployeesFirstArgSalaryIsLess() {
        Employee e1 = new Employee(1, "alice", "anderson", 80000d);
        Employee e2 = new Employee(2, "bob", "bailey", 90000d);
        assertEquals("Should return -1 if the first argument is \"less\"",-1, sut.compare(e1, e2));
    }

    @Test
    public void testCompareWithValidEmployeesSameSalaryFirstArgLastNameAlphabeticallyFirst() {
        Employee e1 = new Employee(1, "alice", "anderson", 90000d);
        Employee e2 = new Employee(2, "bob", "bailey", 90000d);
        assertEquals("Should return -1 if the first argument is \"greater\"",-1, sut.compare(e1, e2));
    }

    @Test
    public void testCompareWithNullEmployees() {
        assertEquals(0, sut.compare(null, null));
    }

    @Test
    public void testCompareWithFirstArgNull() {
        Employee e2 = new Employee(2, "bob", "bailey", 90000d);
        assertEquals(-1, sut.compare(null, e2));
    }

    @Test
    public void testCompareWithSecondArgNull() {
        Employee e1 = new Employee(1, "alice", "anderson", 90000d);
        assertEquals(1, sut.compare(e1, null));
    }

}
