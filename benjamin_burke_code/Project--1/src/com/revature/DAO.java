package com.revature;

import java.io.File;

public class DAO {
    private final static String fileLocation = "src/com/revature/Users.txt";

    /*
        Even though I added the file manually lets create a method
        to create an empty users.txt if it isn't already there
     */

    static {
        File file = new File(fileLocation);
        boolean fileExists = file.exists();
        if(!file.exists()){
            try {
                fileExists = file.createNewFile();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        if(fileExists) System.out.println("The file exists!");
        else System.out.println("no users.txt");
    }


}
