package com.revature;

import com.revature.models.LoginDriver;
import com.revature.models.UserB;

import java.util.List;
import java.util.Scanner;

import static com.revature.models.WriteFile.writeFil;

public class RegisterDriver {

    private UserB myUser = new UserB();
    private MainPageDriver home = new MainPageDriver();

    public void Register(List<UserB> myReg){

        System.out.println("Enter your information to register");
        System.out.println("Username: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
                "\t\t  Must include at least 1 number");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        boolean usernameValid = UserB.validate(user); //test if username conditions are met
       if (usernameValid == true){
           myUser.setUsername(user); //if met, store username
        } else{return;}

        System.out.println("Password: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
                "\t\t  Must include at least 1 number");
        scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        boolean passValid = UserB.validate(pass); // test if password conditions are met
        if(passValid != true){
            return;
            }
        else {
            myUser.setPassword(pass); //if met, store password

            try {
                for(UserB u : myReg){
                    if(u.getUsername().equals(user)) { //compares new username to file
                        System.out.println("Invalid Entry"); //
                        return;
                    }
                }
                //create new user and write file
                System.out.println("Enter Initial Deposit: ");
                Double initBal = scanner.nextDouble();
                myUser.setBalance(initBal);
                myReg.add(myUser);
                writeFil(myReg);
                LoginDriver.Login(myReg); // forwards to login

            }
            catch (Exception e){
                //retrun to main
                System.out.println("invalid user name");
                e.printStackTrace();
            }
        }

    }


}
