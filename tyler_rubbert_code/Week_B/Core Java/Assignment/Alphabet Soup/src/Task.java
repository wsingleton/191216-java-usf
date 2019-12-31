import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        if (phrase == null) {
            return "";
        }
        phrase.trim();
        if (phrase.equals("")) {
            return "";
        }
        List<String> wordList = new ArrayList<>(Arrays.asList(phrase.split(" ")));



    }

}