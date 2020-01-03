import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        String str = wordArray.toString();

        if(str == null || str.equals("")){
            return "";
        }
        str = str.replaceAll("\\s", "");
         for(int i = 0; i<= str.length(); i++){
             char start = str.charAt(i);
             char end = str.charAt(str.length()-1);
             if(start == end) {

             }
         }


    }

    public boolean isPalindrome(String word) {

        /* Provide your implementation here */

    }

}