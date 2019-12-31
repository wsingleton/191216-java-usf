import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if(wordArray == null || wordArray.length == 0){
            return new String[0];
        }
        String[] copy = new String[0];

        for(int i =0;i<wordArray.length;i++){
            if(isPalindrome(wordArray[i]))
            {copy = Arrays.copyOf(copy,copy.length+1);
            copy[copy.length -1]= wordArray[i];
            }
        }

return copy;
    }

    public boolean isPalindrome(String word) {

        if(word == null){
            return false;
        }
        word = word.toLowerCase().replaceAll("\\W","")
                .replaceAll("\\s","");
        int i =0;
        int j = word.length() - 1;

        while(i<j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

}