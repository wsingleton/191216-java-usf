import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {
        Scanner scanner = null;
        String[] wordArray = new String[0];
        if (file == null) return wordArray;
        ArrayList<String> words = new ArrayList<String>();
        try{ scanner = new Scanner(file);
            while(scanner.hasNext()) {
                words.add(scanner.next());
            }
        }
        catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            return new String[0];
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new String[0];
        }
        wordArray = words.toArray(wordArray);
        return wordArray;
    }

    public Map<String, Integer> countWords(String[] extractedText) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        if (extractedText == null || extractedText.length == 0) {
            return wordMap;
        }
        for(String word:extractedText) {
            if(wordMap.containsKey(word)) {
                Integer i = wordMap.get(word);
                i++;
                wordMap.put(word, i);
            }
            else { wordMap.put(word, 1); }
        }
        return wordMap;
    }

}
