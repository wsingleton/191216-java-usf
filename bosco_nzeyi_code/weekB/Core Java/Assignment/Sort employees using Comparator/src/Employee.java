import java.util.Objects;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(){
        super();
    }

    public Employee(int id, String firstName, String lastName, double salary) {

        if(id > 0){
            this.id = id;
        } else {
            id = 0;
        }

        this.firstName = firstName;
        this.lastName = lastName;

        if(salary > 0){
            this.salary = salary;
        } else {
            salary = 0;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if (id > 0){
            this.id = id;
        } else {
            setId(1);
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else{
            salary = getSalary();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

