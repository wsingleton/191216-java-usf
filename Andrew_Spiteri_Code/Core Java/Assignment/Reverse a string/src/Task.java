import java.nio.charset.Charset;
import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        if(reverseMe == null || reverseMe.isEmpty()){
            return "";
        }

        int i = 0, j=reverseMe.length()-1;
        while(i < 0){
            reverseMe.replace(reverseMe.charAt(i), reverseMe.charAt(j)).replace(reverseMe.charAt(j), reverseMe.charAt(i));
            i++;
            j--;
        }
        System.out.println(reverseMe);
        return reverseMe;
    }
}
