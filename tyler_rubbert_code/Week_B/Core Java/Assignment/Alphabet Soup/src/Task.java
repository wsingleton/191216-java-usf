import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        if (phrase == null || phrase.trim().equals("")) {
            return "";
        }

        String result = "";

        phrase = phrase.trim().replaceAll("'", "");
        phrase = phrase.replaceAll("[0-9]","").replaceAll("[^a-zA-Z]+", " ");
        List<String> wordList = new ArrayList(Arrays.asList(phrase.split(" ")));


        for (String s : wordList) {
            result = result.concat(String.valueOf(s.charAt(0)));
        }

        return result.toUpperCase();


    }

}