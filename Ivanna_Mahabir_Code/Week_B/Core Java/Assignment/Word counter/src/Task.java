import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) throws IOException {

        if(!file.exists()){return null;}

       String[] stringList = new String[0];

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();


        while(line != null){
            String[] wordArray = line.split("\\s");

            line = reader.readLine();
        }
        return stringList;
    }

    public Map<String, Integer> countWords(String[] extractedText) {

        // Provide your implementation

    }

}
