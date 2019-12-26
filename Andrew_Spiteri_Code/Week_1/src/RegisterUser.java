import models.Role;
import models.User;

import java.io.*;
import java.lang.System;
import java.util.Random;
import java.util.Scanner;

public class RegisterUser {
    public static User registerUser() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("First name: ");
        String firstname =sc.next();
        System.out.print("Last name: ");
        String lastname =sc.next();
        System.out.print("Username: ");
        String username =sc.next();
        System.out.print("Password: ");
        String password =sc.next();

        Random random = new Random();
        random.setSeed(1234567890);

        File file =new File("resources\\users.txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            User user = new User(random.nextInt(),firstname, lastname, username, password, Role.MEMBER);
            writer.write("\n" + user.toFileString());
            return user;
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
