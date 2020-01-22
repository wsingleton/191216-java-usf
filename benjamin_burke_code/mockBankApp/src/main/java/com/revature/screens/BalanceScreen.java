package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.Account;
import com.revature.repos.AccountRepository;

import static com.revature.AppDriver.*;


public class BalanceScreen  extends Screen {
    public BalanceScreen(){
        super("BalanceScreen","/balance");
        System.out.println("[LOG] - Instantiating "+ super.getName());
    }


    @Override
    public void render() {

        try {
            System.out.println("\n\n\n\n\n\n\n\n\n+-------------------------------+\n");
            System.out.println("The Balance on your  account"+
                     " is: \n"+ "This much");

            System.out.println("To make a deposit enter 1\n" +
                    "To make a withdrawal enter 2");
            System.out.println("To exit logout 0");

            String Input = console.readLine();
            switch (Input) {
                case "1":
                    System.out.println("User can make a deposit");
                    router.navigate("/deposit");


                case "2":
                    System.out.println("You can now make a withdrawal");
                    router.navigate("/withdrawal");

                case "0":
                    System.out.println("Logging out...");
                    router.navigate("/home");

                default:
                    System.out.println("Not a valid input");
            }}catch(InvalidRequestException | ResourcePersistentException e){
            System.err.println("Invalid values provided");
        }catch(Exception e){
            System.err.println("[ERROR] - An Unexpected exception occurred");
            System.out.println("[LOG] - shutting down application");
            appRunning=false;
        }

    }
}
