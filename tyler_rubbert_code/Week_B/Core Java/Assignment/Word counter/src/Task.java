import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {


        String readFile = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while(line != null) {
            readFile += line;
            line = reader.readLine();

            }


        } catch (IOException e) {

        } catch (Exception e) {

        }
        if (readFile == null || readFile.equals("")) {
            return new String[0];
        }

        return readFile.split(" ");


    }

    public Map<String, Integer> countWords(String[] extractedText) {

            if (extractedText == null) {
                return new HashMap<>(0);
            }

            HashMap<String,Integer> countedWords = new HashMap<>();

            for (int i = 0; i < extractedText.length; i ++) {
                int count = 0;
                for (int j = 0; j < extractedText.length; j ++) {
                    if (extractedText[i].equals(extractedText[j])) {
                        count ++;
                    }
                }
                countedWords.put(extractedText[i], count);
            }
            return countedWords;
    }

}
