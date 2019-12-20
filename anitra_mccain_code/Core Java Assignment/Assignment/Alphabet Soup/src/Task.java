import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        // Cover null base case; return empty string if provided phrase is null
        if (phrase == null) return "";

        // Trim the left and right sides of the phrase string in case there is whitespace included
        phrase = phrase.trim();

        // After trimming if the phrase is an empty string, return an empty string
        if (phrase.equals("")) return "";

        // Create a list of phrase words; start with all words separated by spaces
        List<String> phraseWordsList = new ArrayList<>(Arrays.asList(phrase.split(" ")));

        // Stream the words in the list so operations can be performed on them and return the resulting acronym
        return phraseWordsList.stream()

                // Map each word to a uppercase string representing part of the acronym
                .map(word -> {

                    String a = "";

                    // Check for hyphenated words and empty strings
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

                // collect the resulting strings and join them into a single one
                .collect(Collectors.joining());

    }

}