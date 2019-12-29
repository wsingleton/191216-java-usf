import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        String acronym = "";


        if(phrase== null || phrase==""){
            return "";
        }
        for (char c : phrase.toCharArray())
            if (Character.isUpperCase(c))
                acronym +=c;

        return acronym;

    }

}