package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.Account;
import com.liberationbank.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.liberationbank.AppDriver.*;

public class DepositScreen extends Screen {
    public DepositScreen(){
        super("DepositScreen", "/deposit");
        System.out.println("[LOG] - Instantiating "+ super.getName());
    }

    @Override
    public void render() {
        double deposit = 0;
        double newbalance;
        double currentbalance;
        System.out.println("How much would you like to deposit today?");

        try{
            deposit = Double.parseDouble(console.readLine());}
        catch(InputMismatchException e){
            System.out.println("Must be a number");
           // deposit(User,Account);
        }catch(Exception j){}
        //validateDeposit(User,Account,deposit);
        //currentbalance = Account.getBalance();
        //String oldID = Integer.toString(Account.getAccountId());
        //String newID = Integer.toString(Account.getAccountId());
        //String oldbalance = Double.toString(currentbalance);
       // newbalance = deposit + currentbalance;
       // newbalance =formatValue(newbalance);
        //String currentBalance = Double.toString(newbalance);
        //System.out.println("The new balance is:\n" + newbalance);
        //Account.setBalance(newbalance);
        //replaceBalance(oldID, oldbalance,newID,currentBalance);
        System.out.println("Press 1 to return to the main console");
        System.out.println("Press 2 to log out");
        try{
         String Input = console.readLine();
            switch (Input){


                case "1":
                System.out.println("Returning to dashboard...");
                router.navigate("/dashboard");
                case "2":
                router.navigate("/home");
                default:
                System.out.println("Not a valid input");
            }
        } catch(InvalidRequestException | ResourcePersistenceException e){
        System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        }catch(Exception e){
        System.err.println("[ERROR] - An Unexpected exception occured");
        System.out.println("[LOG] - shutting down application");
        appRunning = false;
    }
    }
}
