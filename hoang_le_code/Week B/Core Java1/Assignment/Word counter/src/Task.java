import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {

        String arr[] = new String[0];
        ArrayList<String> strList = new ArrayList<>();

        if (file == null) return new String[0];

        try (Scanner reader = new Scanner(new FileReader(file))) {

            while (reader.hasNext()) {
                String line = reader.next();
                strList.add(line);
            }

            arr = new String[strList.size()];
            arr = strList.toArray(arr);


        } catch (FileNotFoundException fnfe) {
            System.err.println("No file found with name: " + file.getName());
            return new String[0];
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception was thrown.");
            return new String[0];
        }

        return arr;


    }

    public Map<String, Integer> countWords(String[] extractedText) {

        Map<String, Integer> wordCountMap = new Hashtable<>();

        if (extractedText == null || extractedText.length == 0) {
            return wordCountMap;
        }

        for(String word: extractedText) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;

    }

}
