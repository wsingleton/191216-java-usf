package com.revature;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class scratch {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/userBase.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));) {

            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }

        System.out.println();
    }
}
