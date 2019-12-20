package com.bank.models;

import com.bank.services.UserValidation;

import java.util.Objects;

public class User {


    private int Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private  Role role;

    public User() {
        super();
    }

    public User(String Firstname, String Lastname, String Username, String pw, Role Role){
        this.role = Role;
        this.firstName = Firstname;
        this.lastName = Lastname;
        this.userName = Username;
        this.role = Role;
        this.password = pw;
    }
    public User(int id,String Firstname, String Lastname, String Username, String pw, Role Role){
        this(Firstname,Lastname,Username,pw,Role);
        this.Id= id;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id == user.Id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, userName, password, role);
    }

//    public static void setEmail(String email){
//     boolean continuation=false;
//   do {
//       if (UserValidation.isEmail(email)) {
//           this.Email= email;
//           continuation = true;
//       } else
//
//   }while(!continuation);
//
// }
}
