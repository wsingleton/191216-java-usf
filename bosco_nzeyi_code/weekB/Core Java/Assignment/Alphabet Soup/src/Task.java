import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        if (phrase == null) {
            return new String("");

        }
        String toAcronym = phrase.trim().replaceAll("\\s+", " ")
                .replaceAll("-", " ");
    if(toAcronym.equals("") || toAcronym.length() == 0){
        return new String("");
    }
        String[] str = toAcronym.split(" ");

        String acronym = "";
        // trim the phrase to avoid empty spaces on both ends
//        String [] toAcronym = phrase.split(" ");
        for(int i = 0; i<str.length; i++){
            acronym = acronym + str[i].charAt(0);
        }



        return acronym.toUpperCase();

    }

}