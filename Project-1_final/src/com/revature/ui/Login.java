package com.revature.ui;

import com.revature.UserInfo;
import jdk.nashorn.internal.runtime.ECMAException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    public static void loginInfo() {

        // Make a file to store the user info
        File takeNames = new File("src/stored/usernames_passwords.txt");

        System.out.println("Please enter your username");
        Scanner enter = new Scanner(System.in);
        String registeredUName = enter.nextLine();
        System.out.println("Please enter your password");
        Scanner enterpw = new Scanner(System.in);
        String registeredPassword = enterpw.nextLine();

        try {
            int lineCount = 0;

            BufferedReader nameAndPasswordCheck = new BufferedReader(new FileReader(takeNames));
            System.out.println(registeredUName + ":" + registeredPassword);

            String line = nameAndPasswordCheck.readLine();
            ArrayList<UserInfo> usernameAndPasswords = new ArrayList<>();

            for (line) {
                String[] userFields = line.split(":");
                UserInfo u = new UserInfo(userFields[0], userFields[1], Double.parseDouble(userFields[2]));
                usernameAndPasswords.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
