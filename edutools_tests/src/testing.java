import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testing {
    public static void main(String[] args) {

        public String createAcrFromWords (String phrase){
            if (phrase.length() == 0) {
                return "";
            }

            //Set phrase into an array split by the spaces
            List<String> p = new ArrayList<>();
            p = Arrays.asList(phrase.split(" "));
            //Delete the space or w.e characters are in between
            System.out.println(p.get(0));
            return p.toString();
            //Return the new string
        }
    }
}
