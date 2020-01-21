package pojo;

public class Pojo {
        String firstName  =null;
        String lastName = null;
        String username = null;
        String password = null;
        Integer Id = 0;
        String role = null;

        public String getfirstName() { return firstName; }
        public void setfirstName(String firstName) { this.firstName=firstName; }

        public Integer getId() { return Id; }
        public void setId(Integer Id) { this.Id = Id; }

        public String getlastName() { return lastName; }
        public void setlastName(String lastName) { this.lastName=lastName; }

        public String getusername() { return username; }
        public void setusername(String username) { this.username=username; }

        public String getpassword() { return password; }
        public void setpassword(String password) { this.password=password; }

        public String getrole() { return role; }
        public void role(String role) { this.role=role; }
    }
