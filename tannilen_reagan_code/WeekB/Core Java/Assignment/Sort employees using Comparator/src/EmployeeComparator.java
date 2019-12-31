import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1==null && o2==null) {
            return 0;
        }
        if (o1==null) {
            return -1;
        }
        if (o2==null) {
            return 1;
        }
        if (o1.getSalary()>o2.getSalary()) {
            return 1;
        }
        if (o1.getSalary()<o2.getSalary()) {
            return -1;
        }
        else {
            String emp1=o1.getLastName();
            String emp2=o2.getLastName();
            if (emp1.compareTo(emp2)>0) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

}
