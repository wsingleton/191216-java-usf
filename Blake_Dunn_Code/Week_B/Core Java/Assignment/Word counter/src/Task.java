import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {

        if (file == null){
            return new String[0];
        }
        String[] token = new String[0];

        try (Scanner reader = new Scanner(new FileReader(file))) {


            while (reader.hasNext()) {
                String line = reader.next();
                token = Arrays.copyOf(token, token.length + 1);
                token[token.length - 1] = line;
            }

        }catch (FileNotFoundException fnf) {
            System.err.println("File does not exist.");
            return new String[0];
        }catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
        return token;
    }

    public Map<String, Integer> countWords(String[] extractedText) {


        Map<String, Integer> map = new HashMap<>();

        if (extractedText == null || extractedText.length == 0) {
            return map;
        }


        for (String s : extractedText) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            }
            else {
                int count = map.get(s);
                map.put(s, count + 1);
            }
        }

        return map;

    }

}
