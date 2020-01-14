package com.revature.project0.screens;

import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

import static com.revature.project0.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");


        this.userService = userService;

    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;
        String accountType="saving";
        Double balance = 0.0;




        try{

            System.out.println("\n+-----------------------+\n");
            System.out.println("Signup for new account");
            System.out.println("firstname : ");
            firstName = console.readLine();
            System.out.println("last name :");
            lastName = console.readLine();
            System.out.println("User name :");
            username = console.readLine();
            System.out.println("password");
            password = console.readLine();

            // create account

            String input = "";

            while( input != "3"){
                System.out.println("please chose one type of account ");
                System.out.println("1---Checking---");
                System.out.println("2---Saving---");
                System.out.println("enter your choise");
                input = console.readLine();
                switch (input) {
                    case "1":{
                        accountType = "Checking";
                        String inp = "0.0";
                        System.out.println(" enter amount you want to deposit");

                        inp = console.readLine();
                        try{
                            balance = Double.parseDouble(inp);
                            input = "3";
                        }
                        catch(Exception e){
                            System.err.println("enter number only");
                        }
                        break;
                    }
                    case "2":{
                        accountType = "Saving";
                        String inp = "0.0";
                        System.out.println(" enter amount you want to deposit");

                        inp = console.readLine();
                        try{
                            balance = Double.parseDouble(inp);
                            input = "3";
                        }
                        catch(Exception e){
                            System.err.println("enter number only");
                        }
                        break;
                    }
                    default:
                        System.out.println("you chosed wrong option");
                        break;
                }


            }



            if( balance <= 0){
                System.err.println("please enter an positive number");
                System.out.println(" Going back to Register screen ");
                router.navigate("/register");
            }
            else {
                User newUser = new User(firstName,lastName,username,password);
                userService.register(newUser);

                int newId = currentUser.getId();


                Accounts newAcc = new Accounts(accountType,balance);


                AccountService accountService = new AccountService();
                accountService.register(newAcc,newId);

            }



            if(currentUser != null){
                System.out.println("New user created!");
                router.navigate("/home");
            }



        }catch (InvalidRequestException | ResourcePersistenceException e){
            System.out.println("Registration fail, invalid values provide");

        }catch (Exception e){
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }

}