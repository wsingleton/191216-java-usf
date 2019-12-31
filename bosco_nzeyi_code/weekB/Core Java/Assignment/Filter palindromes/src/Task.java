import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {


        if(wordArray == null || wordArray.length == 0){
            return new String[0];
        }
        String[] str = new String[0];

        for(int i = 0; i < wordArray.length; i++){
            if(isPalindrome(wordArray[i])){
                str = Arrays.copyOf(str, str.length + 1);
                str[str.length - 1] = wordArray[i];
            }
        }
        return str;

    }

    public boolean isPalindrome(String word) {

        String str = word;
        if(str == null){
            return false;
        }
        str = str.toLowerCase().replaceAll("\\W", "")
                .replaceAll("\\s", "");
        int piece = 0;
        int ofSht = str.length() - 1;

        while (piece < ofSht){
            if(str.charAt(piece) != str.charAt(ofSht)){
                return false;
            }
            piece ++;
            ofSht--;
        }
        return true;

    }

}