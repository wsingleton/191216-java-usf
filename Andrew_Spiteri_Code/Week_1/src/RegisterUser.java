import java.io.IOException;
import java.lang.System;

public class RegisterUser {
    private String username, password, firstName, lastName, id, role;

    RegisterUser(){

        String[] user = {getUserName(), getPassword(),getFirstName(),getLastName(),getID(),getRole()};
        registerUser(user);
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
    protected static void registerUser(String[] user){
        User newUser = new User(user);
    }
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
}
