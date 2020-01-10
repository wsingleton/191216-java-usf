package com.revature.project0.screens;

import com.revature.project0.repos.AccountRepository;

import static com.revature.project0.AppDriver.console;
import static com.revature.project0.AppDriver.router;

import static com.revature.project0.AppDriver.*;
public class CheckingScreen extends Screen {

    public CheckingScreen() {
        super("ChooseAccountScreen", "/CheckingScreen");

    }
    @Override
    public void render() {
        try{

            String input = "";
            int id = currentUser.getId();
            while( input != "3"){
                System.out.println("---------CHECKING--------");
                System.out.println("What do you want to do today ");
                System.out.println("1---deposit---");
                System.out.println("2---withdraw---");
                System.out.println("3---Quit---");
                System.out.println("enter your choise");
                input = console.readLine();

                switch (input) {
                    case "1":{
                        String inp = "0.0";
                        Double amount =0.0;
                        System.out.println(" enter amount you want to deposit");

                        inp = console.readLine();
                        try{
                            amount = Double.parseDouble(inp);
                        }
                        catch(Exception e){
                            System.err.println("enter number only");

                        }
                        if( amount <= 0){
                            System.err.println("please enter an positive number");
                        }
                        else {
                            AccountRepository a = new AccountRepository();
                            a.deposit("Checking",amount,id);
                        }

                        break;
                    }
                    case "2":{
                        String inp = "0.0";
                        Double amount =0.0;
                        System.out.println(" enter amount you want to withdraw");

                        inp = console.readLine();
                        try{
                            amount = Double.parseDouble(inp);
                        }
                        catch(Exception e){
                            System.err.println("enter number only");
                        }
                        if( amount <= 0){
                            System.err.println("please enter an positive number");
                        }
                        else {
                            AccountRepository a = new AccountRepository();
                            a.withdraw("Checking",amount,id);
                        }

                        break;
                    }
                    case "3":
                        System.out.println("good bye");
                        input = "3";
                        break;
                    default:
                        System.out.println("you chosed wrong option");
                        break;
                }


            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
