import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {


        if (phrase == null) return "";
        phrase = phrase.trim();
        if (phrase.equals("")) return "";
        List<String> phraseWordsList = new ArrayList<>(Arrays.asList(phrase.split(" ")));
        return phraseWordsList.stream()
                .map(word -> {
                    String a = "";
                    word = word.trim();
                    if (word.equals("")) {
                        return a;
                    } else if (word.contains("-")) {
                        for (String part : word.split("-")) a += part.charAt(0);
                    } else {
                        a += word.charAt(0);
                    }
                    return a.toUpperCase();
                })
                .collect(Collectors.joining());

    }

}