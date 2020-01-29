package com.revature;
import com.revature.models.User;
import java.io.*;

public class WriteFileDriver {
    public static void main(String[] args) {
        File writeFile = new File("src/resources/users.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {
            User u = new User(6, "alindsay", "newmember");
            writer.write("\n"+u.toFileString());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception has occurred.");
        }
    }
}