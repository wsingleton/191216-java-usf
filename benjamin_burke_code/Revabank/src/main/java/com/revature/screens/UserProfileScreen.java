package com.revature.screens;

import com.revature.repos.AccountRepository;
import com.revature.services.UserService;

import static com.revature.AppDriver.currentUser;
import static com.revature.AppDriver.router;

public class UserProfileScreen extends Screen {

    private UserService userService;

    public UserProfileScreen(){
        super("UserProfileScreen","/profile");

        this.userService = userService;
    }

    @Override
    public void render(){
        AccountRepository accRepo = new AccountRepository();
        int i = accRepo.isCreatedAccount(currentUser.getId());

        if(i ==3){
            router.navigate("/select");
        }
        if (i==1){
            try{
                String ip = "";

                while (ip !="3"){
                    System.out.println("Please select what you want to do");
                    System.out.println("1) Checking"
                                        + "2) Savings"
                                        + "3) Exit");
                    switch (ip){
                        case"1":
                            router.navigate("/checking"); break;

                        case "2":router.navigate("/saving");break;

                        case "3":
                            System.out.println("Exiting..."); break;

                        default:
                            System.out.println("Invalid input, please choose again"); break;

                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        if(i==2){
            try{
                String ip = "";

                while(ip !="3") {
                    System.out.println("Please select what you want to do");
                    System.out.println("1) Checking"
                            + "2) Savings"
                            + "3) Exit");
                    switch (ip){
                        case"1":
                            router.navigate("/createChecking"); break;

                        case "2":router.navigate("/createSaving");break;

                        case "3":
                            System.out.println("Exiting..."); break;

                        default:
                            System.out.println("Invalid input, please choose again"); break;

                    }

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
