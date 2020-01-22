package com.revature.project0.screens;

import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.services.AccountService;

import static com.revature.project0.AppDriver.*;
import static com.revature.project0.AppDriver.appRunning;

public class CreateSaving extends Screen {

    public CreateSaving() {
        super("CreateSaving", "/CreateSaving");

    }
    @Override
    public void render() {

        Double balance = 0.0;
        try{
            // create account

            String input = "";
            String accountType = "Saving";
            String inp = "0.0";
            System.out.println("how much do you want to deposit?");

            inp = console.readLine();
            try{
                balance = Double.parseDouble(inp);
//                input = "3";
            }
            catch(Exception e){
                System.err.println("enter number only");
            }
            if( balance <= 0){
                System.err.println("please enter an positive number");
            }
            else {
                int newId = currentUser.getId();


                Accounts newAcc = new Accounts(accountType,balance);


                AccountService accountService = new AccountService();
                accountService.register(newAcc,newId);

                if(currentUser != null){
                    System.out.println("[log] - new Saving account created! ");
                    router.navigate("/choose");
                }
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
