import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        if (phrase != null) {
        String s = phrase.replaceAll("[a-z]","").replaceAll("[\\W]", "");
        return s;
        }
        else return "";
    }

}