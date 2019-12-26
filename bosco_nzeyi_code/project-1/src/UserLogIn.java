/*
This class is used to log in an existing account holder
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UserLogIn {

    public String LoggedId;
    public String nextChoice;

    public void login(String username, String password){
// read the file to check whether the provided inputs are included
        ArrayList<String>  users = FileManager.readerTool("users.txt");

        for(String user: users){
            if(user.contains(username) && user.contains(password)){
                int indexOfBar = user.indexOf("|");
//                System.out.println("first vertical bar in the string is at index " + indexOfEmpty);
                String userId = user.substring(0, indexOfBar);
                this.LoggedId = userId;
                int userNameIndex = user.indexOf(username);

                // the first name and last name substring is between the id and first index of username
                String firstAndLastName = user.substring(indexOfBar, userNameIndex);
                String fullName = firstAndLastName.replace("|", " ");
                System.out.println("Welcome!" + fullName);
                Scanner cont = new Scanner(System.in);
                System.out.println("Choose any of the option below to continue " + "\n"+
                        "");


            }
        }

    }
}
