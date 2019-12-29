import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>  {

    @Override
    public int compare(Employee employee, Employee employee2) {
        if(employee == null && employee2 == null){
            return 0;
        }
        else if(employee == null){
            return -1;
        }
        else if(employee2 == null){
            return 1;
        }
        else if(employee.getSalary() == employee2.getSalary()){
           return employee.getLastName().compareTo(employee2.getLastName());
        }
        else if (employee.getSalary() > employee2.getSalary()){
            return 1;
        }
        else if(employee.getSalary() < employee2.getSalary()){
            return -1;
        }
        return 0;
    }

    // A method implementation will go here

}
