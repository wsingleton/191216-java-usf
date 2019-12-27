import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        if (phrase == null) {
            return "";
        }
        if (phrase.trim()=="") {
            return "";
        }
        else {
            String restring = phrase.replace(' ', '-');
            ArrayList<String> wordCapture = new ArrayList<>();
            String[] words = restring.split("-");
            for (int i = 0; i < words.length; i++) {
                if (words[i].trim()!="") {
                    wordCapture.add(words[i]);
                }
            }
            int wordCount = wordCapture.size();
            String solution = "";
            for (int i = 0; i < wordCount; i++) {
                if (!Character.isAlphabetic(wordCapture.get(i).charAt(0))) {
                    wordCapture.remove(i);
                    if (i > 0) {
                        i--;
                    }
                    wordCount--;
                }
            }
            for (int i = 0; i < wordCount; i++) {
                solution = solution + (wordCapture.get(i).charAt(0));
            }
            String acronym = solution.toUpperCase();
            return acronym;
        }
    }
}