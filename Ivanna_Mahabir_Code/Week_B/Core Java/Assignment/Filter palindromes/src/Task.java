import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        String wordLine = wordArray.toString();
        int size = wordLine.length();

        if(wordArray == null || wordArray.length == 0){
            return new String[0];
        }


       for(int i = 0; i <= size; i++){
           for(int j= i+1; j < size-1; j++) {
               if (isPalindrome(wordLine));
                   return wordArray;
           }

       }


        return wordArray;


    }

    public boolean isPalindrome(String word) {

        int i = 0, j = word.length() - 1;
        String modWord = word.toLowerCase().replaceAll("\\s","");

        while (i < j) {
            if (modWord.charAt(i) != modWord.charAt(j)){
            return false;
            }
            ++i;
            --j;
        }
        return false;
    }

}