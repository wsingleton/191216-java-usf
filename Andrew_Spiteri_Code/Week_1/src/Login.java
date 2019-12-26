import models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    public static User login(){
        Map<String, String> uNamePW = new Hashtable<String, String>();
        File file = new File("resources\\users.txt");
        //StringBuilder line = new StringBuilder();
        String userArray [] = new String [6];
        if(file.exists()){
            try(BufferedReader bReader = new BufferedReader(new FileReader(file))){
                for(int i = 0; i < bReader.read(); i++){
                    String line = bReader.readLine();
                    userArray = line.split(",");
                    uNamePW.put(userArray[1],userArray[2]);
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        uNamePW.containsKey(username);
        Integer passwInt = Objects.hash(password);
        if(passwInt.toString().equals(password)){
            //return the user
            return null;
        }

        return null;
    }
}
