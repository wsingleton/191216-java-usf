//This class writes on the file containing the username and passwords for each user
package com.revature;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TakenNames {

    public static void main(String[] args) {

        File takeNames = new File("src/stored/usernames_passwords.txt");

        try (BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames, true))) {

          UserInfo u = new UserInfo();
          storing.write("\n" + u.addToStored());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
