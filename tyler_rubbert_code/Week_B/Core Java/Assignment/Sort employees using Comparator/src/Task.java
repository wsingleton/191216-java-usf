import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task {

    public List<Employee> sortEmployeesBySalary(List<Employee> employeesForSorting) {
        if (employeesForSorting == null || employeesForSorting.isEmpty()) {
            return new ArrayList<Employee>();
        }

        Collections.sort(employeesForSorting, new EmployeeComparator());
        return employeesForSorting;

    }

}
