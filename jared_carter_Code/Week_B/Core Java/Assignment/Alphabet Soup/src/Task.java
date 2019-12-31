import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {


        if (phrase == null) return "";
        phrase = phrase.trim();
        if (phrase.equals("")) return "";
        List<String> wordList = new ArrayList<>(Arrays.asList(phrase.split(" ")));
        return wordList.stream()
                .map(letters -> {
                    String space = "";
                    letters = letters.trim();
                    if (letters.equals("")) {
                        return space;
                    } else if (letters.contains("-")) {
                        for (String part : letters.split("-")) space += part.charAt(0);
                    } else {
                        space += letters.charAt(0);
                    }
                    return space.toUpperCase();
                }).collect(Collectors.joining());

    }

    /*
        Scanner scanner = new Scanner(System.in);

        String firstWord = in.next();
        String secondWord = in.next();
        String thirdWord = in.next();

        String acr = firstWord.substring(0,1)+secondWord.substring(0,1)+thirdWord.substring;

     */

}


