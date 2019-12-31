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
        String[] textArrray = new String[0];
        try{
            Scanner read = new Scanner(new FileReader(file));
//            BufferedReader read = new BufferedReader(new FileReader(file));
//            String line = read.next();
//            ArrayList<String> allLines = new ArrayList<>();
            while (read.hasNext()){
                String line = read.next();
//                allLines.add(line);
                textArrray = Arrays.copyOf(textArrray, textArrray.length + 1);
                textArrray[textArrray.length - 1] = line;
            }
        }catch(FileNotFoundException e){
            System.err.println("File not found");
            return new String[0];
        }
        catch(Exception e){
            e.printStackTrace();
            return new String[0];
        }
 return textArrray;

    }

    public Map<String, Integer> countWords(String[] extractedText) {

        Map<String, Integer> counter = new HashMap<>();

        if(extractedText == null || extractedText.length ==0){
            return counter;
        }
        for (String word: extractedText){
            if(!counter.containsKey(word)){
                counter.put(word, 1);
            } else {
                int count = counter.get(word);
                counter.put(word, count + 1);
            }
        }
return counter;
    }

}
