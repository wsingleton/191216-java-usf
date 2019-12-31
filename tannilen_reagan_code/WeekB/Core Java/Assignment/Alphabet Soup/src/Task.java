import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        System.out.println(phrase);
        String empty="";
        if (phrase == null) {
            System.out.println("Phrase is null.  Returning empty string.");
            return empty;
        }
        else if (phrase=="") {
            System.out.println("Phrase empty.  Returning empty string.");
            return empty;
        }
        else if (phrase.replaceAll("\\s", "").length()==0) {
            System.out.println("Phrase trims to empty.  Returning empty string.");
            return empty;
        }
        else {
            System.out.println("Phrase valid.  Restringing.");
            String restring = phrase;
            while (restring.contains("  ")) {
                restring = restring.replace("  ", " ");
                System.out.println("Removing excess white space.");
            }
            restring=restring.trim();
            System.out.println(restring);
            restring=restring.replace(" ", "-");
            System.out.println(restring);
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
            System.out.println(acronym);
            return acronym;
        }
    }
}