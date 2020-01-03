import javax.print.attribute.standard.Sides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {


        if (phrase == null) return "";
        phrase = phrase.trim();
        if (phrase.equals("")) return "";

        String[] words = phrase.split(" ");
        String acro = "";

        for (int i = 0; i < words.length; i++) {
            if( words[i] == null || words[i].equals(""));
            else if (words[i].contains("-")){
                String[] hyWords = words[i].split("-");
                for (int j=0; j < hyWords.length; j++) {
                    acro = acro + hyWords[j].charAt(0);
                }
            }
            else
                acro = acro + words[i].charAt(0);

        }
        return acro.toUpperCase();
    }
}
