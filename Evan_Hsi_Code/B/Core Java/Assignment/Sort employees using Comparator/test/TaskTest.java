import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class TaskTest {

  private Task sut;
  private List<Employee> sortedEmployeeList;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(3);

  @Before
  public void setUp() {

    sut = new Task();
    sortedEmployeeList = new ArrayList<>();
    sortedEmployeeList.add(new Employee(1, "alice", "anderson", 40000d));
    sortedEmployeeList.add(new Employee(2, "bob", "bailey", 50000d));
    sortedEmployeeList.add(new Employee(3, "charlie", "chaplin", 60000d));
    sortedEmployeeList.add(new Employee(4, "david", "davidson", 70000d));
    sortedEmployeeList.add(new Employee(5, "ethan", "eastman", 80000d));
    sortedEmployeeList.add(new Employee(6, "frank", "fowler", 80000d));

  }

  @After
  public void tearDown() {
    sut = null;
  }

  @Test
  public void testSolutionWithRandomEmployeeList() {

    List<Employee> randomEmployeeList = new ArrayList<>();
    randomEmployeeList.add(new Employee(6, "frank", "fowler", 80000d));
    randomEmployeeList.add(new Employee(2, "bob", "bailey", 50000d));
    randomEmployeeList.add(new Employee(1, "alice", "anderson", 40000d));
    randomEmployeeList.add(new Employee(4, "david", "davidson", 70000d));
    randomEmployeeList.add(new Employee(5, "ethan", "eastman", 80000d));
    randomEmployeeList.add(new Employee(3, "charlie", "chaplin", 60000d));

    assertEquals(sortedEmployeeList, sut.sortEmployeesBySalary(randomEmployeeList));

  }

  @Test
  public void testSolutionWithReversedEmployeeList() {

    List<Employee> reversedEmployeeList = new ArrayList<>();
    reversedEmployeeList.add(new Employee(6, "frank", "fowler", 80000d));
    reversedEmployeeList.add(new Employee(5, "ethan", "eastman", 80000d));
    reversedEmployeeList.add(new Employee(4, "david", "davidson", 70000d));
    reversedEmployeeList.add(new Employee(3, "charlie", "chaplin", 60000d));
    reversedEmployeeList.add(new Employee(2, "bob", "bailey", 50000d));
    reversedEmployeeList.add(new Employee(1, "alice", "anderson", 40000d));

    assertEquals(sortedEmployeeList, sut.sortEmployeesBySalary(reversedEmployeeList));

  }

  @Test
  public void testSolutionWithPreSortedEmployees() {
    assertEquals(sortedEmployeeList, sut.sortEmployeesBySalary(sortedEmployeeList));
  }

  @Test
  public void testSolutionWithEmptyEmployeeList() {
    assertEquals(new ArrayList<>(), sut.sortEmployeesBySalary(new ArrayList<>()));
  }

  @Test
  public void testSolutionWithNullEmployeeList() {
    assertEquals(new ArrayList<>(), sut.sortEmployeesBySalary(null));
  }

  @Test
  public void testSolutionWithEmployeeListContainingSomeNulls() {

    List<Employee> employeeListWithNulls = new ArrayList<>();
    employeeListWithNulls.add(new Employee(1, "alice", "anderson", 40000d));
    employeeListWithNulls.add(null);
    employeeListWithNulls.add(null);
    employeeListWithNulls.add(new Employee(4, "david", "davidson", 70000d));
    employeeListWithNulls.add(new Employee(5, "ethan", "eastman", 80000d));
    employeeListWithNulls.add(null);

    List<Employee> expectedList = new ArrayList<>();
    expectedList.add(null);
    expectedList.add(null);
    expectedList.add(null);
    expectedList.add(new Employee(1, "alice", "anderson", 40000d));
    expectedList.add(new Employee(4, "david", "davidson", 70000d));
    expectedList.add(new Employee(5, "ethan", "eastman", 80000d));

    assertEquals(expectedList, sut.sortEmployeesBySalary(employeeListWithNulls));

  }

}