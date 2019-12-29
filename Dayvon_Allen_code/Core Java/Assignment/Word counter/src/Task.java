import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {


        String myFile = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                myFile += line;
                line = reader.readLine();
            }

        } catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }
        if(myFile.length() == 0){
            return new String[0];
        }
        return myFile.split(" ");
    }

    public Map<String, Integer> countWords(String[] extractedText) {
        if(extractedText == null){
            return new HashMap<>();
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < extractedText.length; i++){
            int counter = 0;
            for (int j = 0; j < extractedText.length; j++ ) {
                if(extractedText[i].equals(extractedText[j])){
                    counter++;
                }
            }
            map.put(extractedText[i], counter);
        }

        return map;

    }

}
