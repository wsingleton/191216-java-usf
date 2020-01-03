import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if (wordArray == null || wordArray.length == 0) {
            return new String[0];
        }

        String[] palindromes = new String[0];

        int counter = 0;
        for (int i = 0; i < wordArray.length; i++) {
            if (isPalindrome(wordArray[i]) == true) {
                if (wordArray[i] != null && !wordArray[i].equals("")) {
                    palindromes = Arrays.copyOf(palindromes, ++counter);
                    palindromes[counter - 1] = wordArray[i];
                }
            }

        }
        if (palindromes.length > 0) {
            return palindromes;
        }
        else return new String[0];
    }

    public boolean isPalindrome(String word) {

        if (word == null || word.equals("")){
            return false;
        }

        StringBuffer clone = new StringBuffer(word.replaceAll("[^a-zA-Z0-9]+","").toLowerCase());
        clone = clone.reverse();
        if (clone.toString().equals(word.replaceAll("[^a-zA-Z0-9^]+","").toLowerCase())) return true;
        else return false;





    }

}