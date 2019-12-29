package com.fauxnancials.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DocumentationDriver {
    File userAccts=new File("com/fauxnancials/resource/useraccts.txt");
    if (userAccts.exists()) {
        System.out.println("File found.");
    }
    else {
        System.out.println("File not found.");
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(userAccts))) {
        String line = null;
            line = reader.readLine();
        while (line!=null) {
            System.out.println(line);
            line=reader.readLine();
        }
    }
    catch (IOException e) {
        System.err.println("Exception occurred while reading file.");
        System.err.println(e.getMessage());
    }
    catch (Exception e) {
        System.err.println("An unexpected exception occurred.");
        System.err.println(e.getMessage());
    }
}
