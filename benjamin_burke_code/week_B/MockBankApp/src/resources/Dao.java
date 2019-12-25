package resources;

import com.revature.models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

public class Dao {

    final static String file = "src/resources/users.txt";

    void addUser(User u) {
        //need to write user to file
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(file, true)))) {
           writer.write(u.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

