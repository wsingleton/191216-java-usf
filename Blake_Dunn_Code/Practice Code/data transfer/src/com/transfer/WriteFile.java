package com.transfer;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile {

    private String path;
    private boolean appendToFile = false;

    public WriteFile(String filePath) {
        path = filePath;
    }

    public WriteFile(String filePath, boolean appendValue) {
        path = filePath;
        appendToFile = appendValue;
    }

    public void writeToFile(String textLine) throws IOException {

        FileWriter write = new FileWriter(path, appendToFile);
        PrintWriter printLine = new PrintWriter(write);

        printLine.printf("%s" + "%n", textLine);

        printLine.close();
    }
}
