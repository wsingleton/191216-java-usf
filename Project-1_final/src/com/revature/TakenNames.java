package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TakenNames {

    public void takenNames() {

        File takeNames = new File("src/stored/usernames_passwords.txt");

        try {

            BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames, true));
            UserInfo u = new UserInfo();
            storing.write("\n" + u.addToStored());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
