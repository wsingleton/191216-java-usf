package com.transfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private String path;

    public ReadFile (String filePath) {
        path = filePath;
    }

    public String[] OpenFile() throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];

        int i;

        for(i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }

        textReader.close();
        return textData;

    }

    int readLines() throws IOException {

        FileReader fileToRead = new FileReader(path);
        BufferedReader bf = new BufferedReader(fileToRead);

        String aLine;
        int numberOfLines = 0;

        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;
    }
}
