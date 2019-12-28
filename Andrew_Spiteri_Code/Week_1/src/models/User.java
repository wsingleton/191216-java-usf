package models;

import java.util.Objects;

public class User {
    private String username, password, firstName, lastName;
    private String id;
    private String role;
    private Account account;


    public User(String fn, String ln, String username, String pw, String role) {
        // a call to the super class's constructor is implicitly here if it not provided
        // super();

        firstName = fn; // "this" is not required if no parameters match the field name
        lastName = ln; // you can still include it though
        this.username = username; // here we must use "this" to clarify which one we are referencing
        password = pw;
        this.role = role;
    }
    public User(String id, String fn, String ln, String un, String pw, String role) {
        this(fn, ln, un, pw, role ); // constructor chaining
        this.id = id;
    }
    private void setUsername(String username){
        this.username = username;
    }
    private void setPassword(String password){
        this.password = password;
    }
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }
    private void setLastName(String lastName){
        this.lastName = lastName;
    }
    private void setId(String id){ this.id = id; }
    private void setRole(Role role){
        switch (role){
            case DEV:
                this.role = "DEV";
                break;
            case ADMIN:
                this.role = "ADMIN";
                break;
            case MEMBER:
                this.role = "MEMBER";
                break;
            case TESTER:
                this.role = "TESTER";
                break;
        }
    }
//    protected static void registerUser(String[] user){
//        models.User newUser = new models.User(user);
//    }
    public  String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getID(){
        return id;
    }
    public String getRole() {
        return role;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public  Account getAccount(){
        return account;
    }

    public String toFileString(){
        return id + "," + username + "," + hashCode() + "," + firstName + "," + lastName + "," + role + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return ";" + id +
                ","+ firstName +
                "," + lastName +
                "," + username +
                "," + password +
                "," + role +
                ';';
    }
}
