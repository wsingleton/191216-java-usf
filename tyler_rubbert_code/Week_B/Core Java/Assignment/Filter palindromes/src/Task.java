import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if (wordArray == null || wordArray.length == 0) {
            return new String[0];
        }

        int counter = 0;
        for (int i = 0; i < wordArray.length - 1; i++) {
            if (isPalindrome(wordArray[i]) == true) {
                counter ++;
                for (int j = i; j < wordArray.length; j++) {
                    wordArray[i] = wordArray[i+1];
                }
                wordArray = Arrays.copyOf(wordArray, wordArray.length-counter);
            }

        }
        return wordArray;
    }

    public boolean isPalindrome(String word) {

        if (word == null || word.equals("")) {
            return false;
        }
        String clone = word.replaceAll("[^a-zA-Z]","").toLowerCase();




        String s = "";
        for (int i = clone.length()-1; i >= 0;i-- ){
            s = s + clone.charAt(i);
        }
        if (s.equals(word)) {
            return true;
        }

        else {
            return false;
        }

    }

}