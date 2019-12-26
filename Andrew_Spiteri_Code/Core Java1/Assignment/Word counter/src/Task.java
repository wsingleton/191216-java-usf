import java.io.*;
import java.util.*;

public class Task {

    public String[] extractTextFromFile(File file) {

        String [] s = new String[0];
        if(file == null){
            return new String[0];
        }

        try(Scanner scanner = new Scanner(new FileReader(file))){
            while(scanner.hasNext()){
                String line = scanner.next();
                s = Arrays.copyOf(s, s.length +1);
                s[s.length - 1] = line;
            }
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
            return new String[0];
        }catch (Exception e){
            e.printStackTrace();
            return new String[0];
        }
        return s;
    }

    public Map<String, Integer> countWords(String[] extractedText) {

        Map<String, Integer> stringIntegerMap = new Hashtable<>();

        if(extractedText == null || extractedText.length < 1){
            return stringIntegerMap;
        }
        for (String s:
             extractedText) {
            if(stringIntegerMap.containsKey(s)){
                stringIntegerMap.put(s, stringIntegerMap.get(s) + 1);
            }else{
                stringIntegerMap.put(s, 1);
            }
        }
        return stringIntegerMap;


    }

}
