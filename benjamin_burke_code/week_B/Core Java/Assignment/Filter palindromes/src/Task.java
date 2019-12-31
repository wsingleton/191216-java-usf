import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if(wordArray==null|| wordArray.length==0){
            return new String[0];
        }
        String palstr ="";
        for (String s: wordArray){
            if(s !=null && !s.equals("")){
                if(isPalindrome(s)){
                    palstr+=s + " ";
                }
            }
        }
        if(palstr.length()>0){
            return palstr.split("_")
        }
        return new String[0];

    }

    public boolean isPalindrome(String word) {



    }

}