import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SignUpUsers {

    /* this class will take in user info from the command line
    and push it in an array or object that will hold userdata
     */
//    private int id;
//    private String firstName;
//    private String lastName;
//    private String username;
//    private String password;

    // method to create a user id

    public int generateId (){
        // this method will read the file and count the number of users registered.
        // the id is the last id + 1. The ids, just like in SQL, will be consecutive.
        int newId = FileManager.getId();
        return newId;

    }

    // method to register the user and save their info to the file

    public void registerUser(String firstName, String lastName, String username, String password){

//        this.firstName = firstname;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;

        // build a string to write into the users.txt file
        System.out.println("the generated id is " + this.generateId());
        String userData = this.generateId() + "|" + firstName + "|" + lastName + "|" + username + "|" + password;

        // write the string to the file by calling the file manager class to do it
        FileManager.writeFile("users.txt", userData);

    }
}
