import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Task {

    public String[] extractTextFromFile(File file) throws IOException {

        if(file.exists() == false){
            return null;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while(line != null){
            line = reader.readLine();
            String[] wordArray = line.split("\\s");
            return wordArray;
        }
    }

    public Map<String, Integer> countWords(String[] extractedText) {

        // Provide your implementation

    }

}
