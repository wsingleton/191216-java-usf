import java.lang.reflect.Array;
import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {
        if (reverseMe==null) {
            System.out.println("Null value.");
            return null;
        }
        if (reverseMe=="") {
            System.out.println("No value provided.");
            return "";
        }
        char word[]=reverseMe.toCharArray();
        String reversed="";
        for (int i=0; i<reverseMe.length(); i++) {
            int indexMod = i+1;
            reversed=reversed+word[reverseMe.length()-indexMod];
        }
        return reversed;
    }
}