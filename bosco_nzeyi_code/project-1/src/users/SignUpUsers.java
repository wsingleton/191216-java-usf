package users;

import accounting.FileManager;

import java.util.Scanner;

public class SignUpUsers {

    // get user inputs
    public void getInput(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName = read.nextLine();
        System.out.println("Enter your last name");
        String lastName = read.nextLine();
        System.out.println("Enter username");
        String username = read.nextLine();
        System.out.println("Enter password");
        String password = read.nextLine();
        System.out.println("confirm password");
        String password2 = read.nextLine();
        boolean passChecker = password.equals(password2);

        if (passChecker){
            System.out.println("password match! Proceeding ...");
            this.registerUser(firstName, lastName, username, password);
        } else {
            System.out.println("Password mismatch. enter 1 to try again or 0 to exit");
            String redo = read.nextLine();
            if(redo.equals("1")){
                getInput();
            } else {
                System.out.println("try again");
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
