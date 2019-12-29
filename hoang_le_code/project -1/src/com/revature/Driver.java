package com.revature;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.out.println("---Welcome to bank account app---");
        Scanner sn = new Scanner(System.in);

        String input = "";
        String userName;
        String pw;
        String fn;
        String ln;
        while( input != "3"){
            System.out.println("please chose one of the option below ");
            System.out.println("1---Login---");
            System.out.println("2---register---");
            System.out.println("3---Quit---");
            input = sn.nextLine();
            switch (input) {
                case "1":{

                    System.out.println("please enter user name and password");
                    System.out.println("User Name: ");

                    userName = sn.nextLine();

                    System.out.println("password: ");

                    pw = sn.nextLine();

                    UserDao user = new UserDao();
                    user.login(userName,pw);
                    System.out.println(" ---------------------------");

                    break;
                }
                case "2":{
                    System.out.println("please fill in the infomation");
                    System.out.println("first Name: ");

                    fn = sn.nextLine();

                    System.out.println("last name: ");
                    ln = sn.nextLine();


                    System.out.println("user name");
                    userName = sn.nextLine();

                    System.out.println("pass word: ");
                    pw = sn.nextLine();



                    User myUser= new User(fn,ln,userName,pw) ;



                    UserDao user= new UserDao(myUser);


                    user.saveInfo();
                    System.out.println(" you are registered ");
                    System.out.println(" ---------------------------");


                    break;
                }
                case "3":
                    System.out.println("good bye");
                    input = "3";
                    break;
                default:
                    System.out.println("you choosed wrong option");
                    break;
            }


        }

    }

}
