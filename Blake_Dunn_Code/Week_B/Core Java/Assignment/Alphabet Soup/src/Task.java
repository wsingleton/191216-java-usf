import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        if(phrase == null)
            return new String("");

        phrase = phrase.trim().replaceAll("\\s+", " ");

        if (phrase.equals("") || phrase.length() == 0)
            return new String("");


        char[] charArray = phrase.toCharArray();

        ArrayList<String> acronym = new ArrayList<>();

        String string1 = Character.toString(charArray[0]);
        acronym.add(string1);

        for(int i = 1; i < charArray.length; i++) {
            if(charArray[i] == ' ' || charArray[i] == '-') {
                String string2 = Character.toString(charArray[i + 1]);
                acronym.add(string2);
            }
        }

        StringBuffer buffer = new StringBuffer();

        for (String str : acronym) {
            buffer.append(str);
        }

        String result = buffer.toString();

        String result1 = result.toUpperCase();
        return result1;








    }

}