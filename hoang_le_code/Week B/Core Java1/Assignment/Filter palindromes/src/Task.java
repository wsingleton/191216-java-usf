import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if (wordArray == null || wordArray.length == 0) {
            return new String[0];
        }
        String[] anotherArray = new String[0];

        for (int i = 0 ; i < wordArray.length; i++){
            if (isPalindrome(wordArray[i]) == true){
                anotherArray = new String[wordArray.length - 1];

                // Copy the elements except the index
                // from original array to the other array
                for (int j = 0, k = 0; k < wordArray.length; j++) {
                    // if the index is
                    // the removal element index
                    if (j == i) {
                        continue;
                    }

                    // if the index is not
                    // the removal element index
                    anotherArray[k] = wordArray[j];

                }


            }

        }



        return anotherArray;

    }

    public boolean isPalindrome(String word) {

        String str = word.toLowerCase().replaceAll("\\W", "");
        StringBuilder reverse = new StringBuilder(str).reverse();

        if(str.equals(reverse.toString()) == true){
            return true;
        }
        else {
            return false;
        }

    }

}