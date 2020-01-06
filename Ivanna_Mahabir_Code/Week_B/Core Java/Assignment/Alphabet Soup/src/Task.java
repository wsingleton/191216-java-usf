import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        if(phrase == null || phrase.equals("")) {
            return "";
        }
        phrase = phrase.trim();

        List<String> slist = new ArrayList<>();
        while (phrase != null){
            String[] str = phrase.split("\\s, -");
            String u = new String(String.valueOf(str.toString().charAt(0)));
            slist.add(u);

        }




        return slist.toString();

    }

}