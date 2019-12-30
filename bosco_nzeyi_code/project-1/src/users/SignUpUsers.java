package users;

import accounting.FileManager;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SignUpUsers {

    // var for user input verification
    public boolean passed = false;

    // verify String input
    public boolean verifyString (String input) {
        Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        if (pattern.matcher(input).matches() && input.length() > 2 && input.length() < 12 ) {
            passed = true;
//            throw new IllegalArgumentException("Invalid Name");
        }
//        else if (input.length() > 12 || input.length() < 2){
//            passed = false;
//            System.err.println("Invalid size. Input should be more than 1 and less than 12 characters");
//        }
        else {
            passed = false;
//            throw new IllegalArgumentException("Invalid Name");
            System.err.println("Input should be characters only with more than 2 or less than 12 characters");
        }
        return passed;
    }

    // get user inputs
    public void getInput(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName = read.nextLine().trim();
        System.out.println("Enter your last name");
        String lastName = read.nextLine().trim();
        System.out.println("Enter username");
        String username = read.nextLine().trim();
        System.out.println("Enter password. Should be less than 9 characters");
        String password = read.nextLine().trim();
        System.out.println("confirm password");
        String password2 = read.nextLine().trim();
        boolean passChecker = password.equals(password2);

        if (!(password.length() > 8) && passChecker && verifyString(firstName) && verifyString(lastName) && verifyString(username)){
            System.out.println("password match! Proceeding ...");
            this.registerUser(firstName, lastName, username, password);
        } else {
            System.out.println("Password mismatch. enter 1 to try again or any key to exit to exit");
            String redo = read.nextLine();
            if(redo.equals("1")){
                getInput();
            } else {
                System.exit(0);
//                System.out.println("try again");
            }
        }
    }

    // method to create a user id
    public int generateId (){
        // this method read the file and count the number of users registered.
        // the id is the last id + 1. The ids, just like in SQL, will be consecutive.
        int newId = FileManager.getId();
        return newId;
    }

    // method to register the user and save their info to the file
    public void registerUser(String firstName, String lastName, String username, String password){

        String userData = this.generateId() + "|" + firstName + "|" + lastName + "|" + username + "|" + password;
        FileManager.writeFile("users.txt", userData);
        System.out.println("Successfully registered!");

    }
}
