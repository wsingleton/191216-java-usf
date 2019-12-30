package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class WriteFileDriver {

    public static void main(String[]  args)  {

        File writeFile = new File("src/resources/users.txt");

        //try-withresources (introduced in Java 7) :: auto-class objects declared as resources
        try (BufferedWriter writer) = new BufferedWriter(new FileReader(writeFile)))  {
        User u = new User(4,  "rconnell", "java");
        writer.erite("\n" + u.toFileString());


        } catch (Exception e) {
            e.printStackTrace(;
        }
    }
}
