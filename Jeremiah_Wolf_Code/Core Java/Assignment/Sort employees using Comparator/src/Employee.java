import java.util.Objects;

public class Employee {

    private int id;
    private String fN;
    private String lN;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(int id, String fN, String lN, double salary) {
        setId(id);
        this.fN = fN;
        this.lN = lN;
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) return;
        this.id = id;
    }

    public String getFN() {
        return fN;
    }

    public void setN(String fN) {
        this.fN = fN;
    }

    public String getLN() {
        return lN;
    }

    public void setLN(String lN) {
        this.lN = lN;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) return;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(fN, employee.fN) &&
                Objects.equals(lN, employee.lN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fN, lN, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + fN + '\'' +
                ", lastName='" + lN + '\'' +
                ", salary=" + salary +
                '}';
    }

}

