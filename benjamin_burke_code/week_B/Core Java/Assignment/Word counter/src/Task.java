import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {


        String readFile = " ";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while(line != null){
                System.out.println(line);
                readFile += line;
                line = reader.readLine();
            }

        }catch (IOException ioe){
            System.out.println("Exception thrown while reading the file");
        } catch (Exception e) {
            System.out.println("An exception occured");
        }
        if(readFile.length()==0){
            return new String[0];
        }
        return readFile.split(" ");

    }

    public Map<String, Integer> countWords(String[] extractedText) {

        if(extractedText == null){
            return new HashMap<>();
        }
        HashMap<String, Integer>map= new HashMap<>();
        for (int i=0; i<extractedText.length; i++){
            int counter =0;
            for(int j =0; j<extractedText.length; j++){
                if (extractedText[i].equals(extractedText[j])){
                    counter++;
                }
            }
            map.put(extractedText[i],counter);
        }
        return map;

    }

}
