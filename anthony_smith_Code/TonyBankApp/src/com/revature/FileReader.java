package com.revature;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {

    public static void filedMap(HashMap userDb) {
        String fileName = "/Users/Kusher/Documents/batch_repos/191216-java-usf/anthony_smith_Code/TonyBankApp/src/com/revature/database";
        File file = new File(fileName);
        Scanner scanner = null;
        Double balance;
        String un;
        String pw;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                un = scanner.next();
                pw = scanner.next();
                balance = scanner.nextDouble();

                User user = new User(un, pw, balance);


                userDb.put(un, user);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

}
