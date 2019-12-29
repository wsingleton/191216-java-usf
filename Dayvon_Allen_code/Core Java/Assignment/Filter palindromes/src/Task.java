import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if(wordArray == null || wordArray.length == 0){
            return new String[0];
        }
        ArrayList<String> holder = new ArrayList<>();
        StringBuilder[] reverseString = new StringBuilder[wordArray.length];
        String[] temp = wordArray;
        for(int i = 0; i < wordArray.length; i++){
            reverseString[i] = reverseString[i].reverse();
        }

        for (int i = 0; i < wordArray.length; i++){
            if(reverseString[i].toString().trim().replaceAll("[^a-zA-Z]+", " ").equals(temp[i].trim().replaceAll("[^a-zA-Z]+", " "))){
                holder.add(temp[i]);
            }
        }
        String[] palin = new String[holder.size()];
        for(int i = 0; i < holder.size(); i++){
            palin[i] = holder.get(i);
        }
        if(palin.length > 0){
            return palin;
        }
        return new String[0];
    }

    public boolean isPalindrome(String word) {

        return true;
    }

}