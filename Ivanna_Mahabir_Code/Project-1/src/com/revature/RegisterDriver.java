package com.revature;

import com.revature.models.UserB;

// use an array to hold info?? output array separated by :
//Create a temporary object and compare to stored data
// if input is the same as stored data display invalid entry

import java.util.List;
import java.util.Scanner;

import static com.revature.models.WriteFile.writeFil;


public class RegisterDriver {

    private UserB myUser = new UserB();

    public void Register(List<UserB> myReg){

        System.out.println("Enter your information to register");
        System.out.println("Username: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
                "\t\t  Must include at least 1 number");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        boolean usernameValid = UserB.validate(user);
       if (usernameValid == true){
           myUser.setUsername(user);
        } else{return;}

        System.out.println("Password: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
                "\t\t  Must include at least 1 number");
        scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        boolean passValid = UserB.validate(pass);
        if(passValid != true){
            return;
            }
        else {
            System.out.println(" pass accept");
            myUser.setPassword(pass);

            try {
                for(UserB u : myReg){
                    if(u.getUsername().equals(user)) {
                        System.out.println("Invalid entry");
                        return;
                    }
                }
                System.out.println("write file");
                myReg.add(myUser);
                //create new user and write file
                writeFil(myReg);
            }
            catch (Exception e){
                System.out.println("invalid user name");
                e.printStackTrace();
            }
        }

    }


}
