package com.revature.project0.screens;
import com.revature.project0.AppDriver;
import com.revature.project0.models.Accounts;
import com.revature.project0.repos.AccountRepository;
import com.revature.project0.services.UserService;

import static com.revature.project0.AppDriver.*;
public class UserProfileScreen extends Screen {
    private UserService userService;
    public UserProfileScreen() {
        super("UserProfileScreen", "/UserProfileScreen");

        this.userService = userService;
    }

    @Override
    public void render() {
        AccountRepository accRepo = new AccountRepository();
        int i = accRepo.isCreatedAccount(currentUser.getId()) ;


        if (i ==3 ){
            router.navigate("/choose");
        }
        if (i == 1) {
            try{

                String input = "";

                while( input != "3"){
                    System.out.println("What you want to do today");
                    System.out.println("1) Checking");
                    System.out.println("2) Saving");
                    System.out.println("3) Quit");
                    System.out.println(">");
                    input = console.readLine();
                    switch (input) {
                        case "1":{
                            router.navigate("/CheckingScreen");
                            break;
                        }
                        case "2":{
                            router.navigate("/CreateSaving");
                            break;
                        }
                        case "3":
                            System.out.println("goodbye");
                            input = "3";
                            break;
                        default:
                            System.out.println("invalid option");
                            break;
                    }


                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(i == 2){
            try{

                String input = "";

                while( input != "3"){
                    System.out.println("Pick an option");
                    System.out.println("1)Saving");
                    System.out.println("2)Create Checking");
                    System.out.println("3---Quit---");
                    System.out.println(">");
                    input = console.readLine();
                    switch (input) {
                        case "1":{
                            router.navigate("/SavingScreen");
                            break;
                        }
                        case "2":{
                            router.navigate("/CreateChecking");
                            break;
                        }
                        case "3":
                            System.out.println("good bye");
                            input = "3";
                            break;
                        default:
                            System.out.println("invalid input");
                            break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}