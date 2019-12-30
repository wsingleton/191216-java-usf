import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        String a = "";

        if(phrase == null || phrase.trim().equals("")){
            return "";
        }

        else {
            a = a+ phrase.charAt(0);
            for(int i = 1; i < phrase.length(); i++){
                if(phrase.charAt(i-1) == ' ' || phrase.charAt(i-1) == '-'){
                    a = a + phrase.charAt(i);

                }
            }


        }
        a= a.replaceAll("[1,2,3,4,5,6,7,8,9 ]","");
        a=a.toUpperCase();
        a=a.trim();
        return a;

    }

}