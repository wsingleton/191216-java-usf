package models;

import models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Login {
    public static void login(){
        Map<String, String> uNamePW = new Hashtable<String, String>();
        File file = new File("resources\\users.txt");
        //StringBuilder line = new StringBuilder();
        System.out.println("Welcome to Mock Bank. Please login to your account.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        String [] holder = new String[0];
        if(file.exists()){
            int counter = 0;
            try(BufferedReader bReader = new BufferedReader(new FileReader(file))){
                for(String line; (line = bReader.readLine()) != null;) {
                    String[] arr = line.split(";");
                    for (int i = 0; i < arr.length; i++) {
                        String[] userArray = arr[i].split(",");
                        if(userArray[1].equals(username)){
                            holder = Arrays.copyOf(userArray, userArray.length);
                        }
                        uNamePW.put(userArray[1], userArray[2]);
                    }
                        if (uNamePW.containsKey(username)) {
                            Integer passwInt = Objects.hash(password);
                            if (passwInt.toString().equals(holder[2])) {
                                //return the user
                                User user = new User(holder[0], holder[1], holder[2], holder[3], holder[4], holder[5]);
                                System.out.println("Welcome to banking app!");
                                Account account = new Account(holder[0]);
                                user.setAccount(account);
                                AccountScreen.printToScreen(user.getAccount());
                                //return user;
                            } else {
                                System.out.println("Wrong username or password!");
                                Login.login();
                            }
                        }else{
                            System.out.println("Wrong username or password!");
                            Login.login();
                        }
                    }

            }catch (IOException ioe){
                ioe.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        //return null;
    }
}
