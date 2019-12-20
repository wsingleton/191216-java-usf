import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setUp() {
        sut = new Employee();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testIfEmployeeIsProperPojo() {
        Class<Employee> clazz = Employee.class;
        try {
            clazz.getMethod("getId");
            clazz.getMethod("getFirstName");
            clazz.getMethod("getLastName");
            clazz.getMethod("getSalary");
            clazz.getMethod("setId", int.class);
            clazz.getMethod("setFirstName", String.class);
            clazz.getMethod("setLastName", String.class);
            clazz.getMethod("setSalary", double.class);
            clazz.getMethod("equals", Object.class);
            clazz.getMethod("hashCode");
            clazz.getMethod("toString");
        } catch (NoSuchMethodException e) {
            fail("Missing required method. Class does not properly implement POJO design pattern.");
        }
    }

    @Test
    public void testToEnsureThatEmployeeCannotBeInstantiatedWithNegativeId() {
        sut = new Employee(-1, "alice", "anderson", 90000d);
        assertEquals("Should not be able to instantiate employee with a negative id", 0, sut.getId());
    }

    @Test
    public void testToEnsureThatEmployeeCannotBeInstantiatedWithNegativeSalary() {
        sut = new Employee(1, "alice", "anderson", -90000d);
        assertEquals("Should not be able to instantiate employee with a negative salary",
                0, sut.getSalary(), 0);
    }

    @Test
    public void testToEnsureThatIdCannotBeSetToNegativeNumber() {
         sut = new Employee(1, "alice", "anderson", 90000d);
         sut.setId(-1);
         assertEquals("Should not be able to set id to negative value",1, sut.getId());
    }

    @Test
    public void testToEnsureThatSalaryCannotBeSetToNegativeNumber() {
        sut = new Employee(1, "alice", "anderson", 90000d);
        sut.setSalary(-100000d);
        assertEquals("Should not be able to set salary to negative value",90000d, sut.getSalary(), 0);
    }

}
