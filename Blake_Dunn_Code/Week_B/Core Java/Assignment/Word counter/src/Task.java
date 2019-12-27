import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Task {

    public String[] extractTextFromFile(File file) {

        if (file.exists()){
            System.out.println("It exists!");
        }else {
            System.out.println("File does not exist.");
            return new String[0];
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            Arrays extractedText = new Arrays();

            while(line != null) {

                extractedText = extractedText.add

            }

        }catch (FileNotFoundException fnf) {
            System.err.println("File does not exist.");
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Map<String, Integer> countWords(String[] extractedText) {

        // Provide your implementation

    }

}
