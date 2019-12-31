import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o, Employee t1) {
        if(o == null && t1 == null) {
            return 0;
        } else if (o == null) {
            return - 1;
        } else if (t1 == null) {
            return 1;
        } else if (o.getSalary() > t1.getSalary()) {
            return 1;
        } else if (o.getSalary() < t1.getSalary()) {
            return -1;
        } else if (o.getSalary() == t1.getSalary()) {
            return o.getLastName().compareTo(t1.getLastName());
        }
            return 0;




    }

}
