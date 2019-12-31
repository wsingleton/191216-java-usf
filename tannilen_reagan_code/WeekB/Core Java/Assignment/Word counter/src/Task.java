import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {

        if (file==null) {
            return new String[0];
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            line=reader.readLine();
            /*
             * Wezley, if you're going to ask us to create something that parses
             * data out of a file, please tell us how that data is divided up, so
             * we're not left guessing whether it's one word per line, a chain of
             * words separated by spaces, a csv format, etc.  It would help a lot.
             */
            if (line==null || line==""){
                return new String[0];
            }
            String[] extracted=line.split(" ");
            return extracted;
        }
        catch (IOException ioe) {
            return new String[0];
        }


    }

    public Map<String, Integer> countWords(String[] extractedText) {

        if (extractedText==null || extractedText.length==0) {
            Map<String,Integer> map=new HashMap<>();
            return map;
            }
        else {
            Map<String, Integer> wordCount=new HashMap<>();
            for (String s:extractedText) {
                if (wordCount.containsKey(s)) {
                    wordCount.put(s,wordCount.get(s)+1);
                }
                else {
                    wordCount.put(s, 1);
                }
            }
            return wordCount;
        }

    }

}
