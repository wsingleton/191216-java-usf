import java.util.ArrayList;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if(wordArray == null || wordArray.length == 0) return new String[0];
        ArrayList<String> pals = new ArrayList<String>();
        for(int i = 0; i < wordArray.length; i++) {
            if(isPalindrome(wordArray[i])) {
                pals.add(wordArray[i]);
            }
        }
        String[] palArray = new String[0];
        palArray = pals.toArray(palArray);
        return palArray;

    }

    public boolean isPalindrome(String word) {
        if(word == null) return false;
        if(word.length() == 0) return true;

        String tempWord = word.toLowerCase().replaceAll("\\W", "");
        StringBuilder reversed = new StringBuilder(tempWord).reverse();
        return tempWord.equals(reversed.toString());
    }

}