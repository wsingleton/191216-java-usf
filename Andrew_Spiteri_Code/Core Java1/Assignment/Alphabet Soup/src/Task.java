import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {

        if (phrase == null || phrase == "")
            return "";
        phrase = phrase.trim();
        char[] charArr = phrase.toCharArray();

        String acronym = new String();
        char holder =  ' ';
        for(int i = 0; i < charArr.length; i++){
               if(holder == ' ' || holder == '-' && charArr[i] != ' ' | charArr[i] != '-')
                   acronym = acronym + charArr[i];
               holder = charArr[i];
        }

        charArr = acronym.toCharArray();
        String answer = new String();
        for (char c:
             charArr) {
            if(c != ' ')
                answer = answer + c;
        }

        return answer.toUpperCase();
    }

}