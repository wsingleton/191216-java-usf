import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1 == null && e2 == null) return 0;
        else if(e1 != null && e2 == null) return 1;
        else if(e1 == null && e2 != null) return -1;
        if(e1.getSalary() == e2.getSalary()){
            return e1.getLastName().compareTo(e2.getLastName());
        }else if(e1.getSalary() > e2.getSalary()){
            return 1;
        }else if(e1.getSalary() < e2.getSalary()){
            return -1;
        }
        return 0;
    }

}
