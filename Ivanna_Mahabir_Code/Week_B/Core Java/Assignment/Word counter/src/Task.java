import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {

        String[] stringList = new String[0];

        if(file  == null) return new String[0];

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                stringList = line.split("\\s");
                line = reader.readLine();
            }
        }


        catch (FileNotFoundException fe) {
            System.err.println("File " + file.getName() + "not found");
            return new String[0];
        }
        catch (Exception e){
            System.err.println("An unexpected error occurred");
            e.printStackTrace();
            return new String[0];
        }

        return stringList;
    }


        public Map<String, Integer> countWords(String[] extractedText) {

        Map<String, Integer> myMap = new Hashtable<>();

        if(extractedText == null || extractedText.length == 0){
            return myMap;
        }

        for(String word : extractedText){
            if(myMap.containsKey(word)) {
                myMap.put(word, myMap.get(word) + 1);
            }
            else{
                myMap.put(word, 1);
            }
        }

        return myMap;
    }

}
