import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        String acronym = "";

        if( phrase == null || phrase == ""){
            return phrase;
        }
//        phrase.replaceAll("")
        for (int i = 0; i < phrase.length(); i++){
            char testChar = phrase.charAt(i);
            if(testChar == Character.toUpperCase(phrase.charAt(i)) && Character.isAlphabetic(testChar)){
                acronym += Character.toString(testChar);
            }
        }
        acronym = acronym.replaceAll("\\s", "");
        return acronym;
    }

}