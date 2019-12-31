import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        if(phrase == null) return "";
        phrase = phrase.trim();
        String acro = "";
        if (phrase.equals("")) return phrase;
        String[] words = phrase.split(" ");
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(""));
            else if(words[i].contains("-")) {
                String[] hyphenWords = words[i].split("-");
                for(String s : hyphenWords) acro += s.charAt(0);
            }
            else if(Character.isAlphabetic(words[i].charAt(0))) {
                acro += words[i].charAt(0);
            }
        }
        return acro.toUpperCase();

    }

}