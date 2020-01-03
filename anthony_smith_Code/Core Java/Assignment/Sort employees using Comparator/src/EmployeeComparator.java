import java.util.Comparator;

public class EmployeeComparator implements Comparator <Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1 == null && o2 == null) return 0;
        if(o1 == null && o2 != null) return -1;
        if(o1 != null && o2 == null) return 1;

        if(o1.getSalary() > o2.getSalary())
            return 1;
        else if(o1.getSalary() < o2.getSalary())
            return -1;
        else {
            return o1.getLastName().compareTo(o2.getLastName());
        }

    }

}
