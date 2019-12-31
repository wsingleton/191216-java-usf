import java.util.ArrayList;
import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        // need to reverse any input in the string
        if (reverseMe.length() == 0) {
            return "";
        }
        String m = "";
        for (int i = reverseMe.length() -1; i >= 0 ; i--) {
            m = m + reverseMe.charAt(i);
        }
        return m;
    }
}