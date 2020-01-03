import java.util.Objects;

public class Employee {
        private int id;
        private String firstName;
        private String lastName;
        private double salary;

        public Employee() {
        }

        public Employee(int id, String firstName, String lastName, double salary) {
            if(id >= 0) {
                this.id = id;
            }
            else this.id = 0;
            this.firstName = firstName;
            this.lastName = lastName;
            if(salary >= 0) {
                this.salary = salary;
            }
            else this.salary = 0;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            if(id >= 0) {
                this.id = id;
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
            if(salary >= 0) {
                this.salary = salary;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id &&
                    Double.compare(employee.salary, salary) == 0 &&
                    Objects.equals(firstName, employee.firstName) &&
                    Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstName, lastName, salary);
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



