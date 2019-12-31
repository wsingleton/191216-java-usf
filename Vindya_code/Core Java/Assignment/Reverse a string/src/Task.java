import java.io.CharConversionException;
import java.util.Stack;

public class Task<Stringchars, stringchars> {

    public String reverse(String reverseMe) {

        if (reverseMe == null)
        return "";

        //reverseMe.equals(("")){ {// Provide your implementation here
        char[] stringchars = reverseMe.toCharArray();
        Stack<Character> characterstack = new Stack<>();
        //char                               //
        for(char C : stringchars){characterstack.push(C);}
        //
        int k = 0;
        while (! characterstack.isEmpty())
        {
            stringchars[k++] = characterstack.pop();
            System.out.println(stringchars);
        }
        return String.copyValueOf(stringchars );
        }
}


