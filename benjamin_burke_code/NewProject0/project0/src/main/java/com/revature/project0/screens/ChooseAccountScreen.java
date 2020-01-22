package com.revature.project0.screens;

import com.revature.project0.repos.AccountRepository;

import static com.revature.project0.AppDriver.*;
public class ChooseAccountScreen extends Screen {



    public ChooseAccountScreen() {
        super("ChooseAccountScreen", "/choose");

    }
    @Override
    public void render() {

        try{

            String input = "";

            while( input != "3"){
                System.out.println("please chose one of the option below ");
                System.out.println("1)Checking");
                System.out.println("2)Saving");
                System.out.println("3)Quit");
                System.out.println(">");
                input = console.readLine();
                switch (input) {
                    case "1":{
                        router.navigate("/CheckingScreen");
                        break;
                    }
                    case "2":{
                        router.navigate("/SavingScreen");
                        break;
                    }
                    case "3":
                        System.out.println("goodbye");
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
