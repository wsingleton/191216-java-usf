import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Task {

    public List<Employee> sortEmployeesBySalary(List<Employee> employeesForSorting) {

        ArrayList<Employee> employeeList = new ArrayList<>();

        if (employeesForSorting == null) {

            return new ArrayList<>();

        }

        if (!employeesForSorting.isEmpty()) {

            for (Employee e : employeesForSorting) {

                if (e != null) {

                    employeeList.add(new Employee(e.getId(), e.getFirstName(), e.getLastName(), e.getSalary()));

                } else {

                    employeeList.add(null);

                }

            }

        } else {

            return new ArrayList<>();

        }

        EmployeeComparator employeeComparator = new EmployeeComparator();


        employeeList.sort(employeeComparator);

        return employeeList;

    }

    }
