import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if(wordArray == null || wordArray.length == 0){

            return new String[0];

        }

        String palinString = "";

        for (String s: wordArray

        ) {

            if (s != null && !s.equals("")){

                if(isPalindrome(s)){

                    palinString += s + " _";

                }

            }

        }

        if(palinString.length() > 0){

            return palinString.split(" _");

        }

        return new String[0];

    }

    public boolean isPalindrome(String word) {

            StringBuffer s = new StringBuffer(word.replaceAll("[^A-Za-z0-9]+", "").toLowerCase());

            s = s.reverse();

            if(s.toString().equals(word.replaceAll("[^A-Za-z0-9]+", "").toLowerCase())){

                return true;

            }

            return false;

        }

    }

