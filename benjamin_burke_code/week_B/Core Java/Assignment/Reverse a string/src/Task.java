import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {
        //check the string
        if (reverseMe == ""|| reverseMe==null){
            return "";
        }

        //crating array of
       char word[]=reverseMe.toCharArray();
        String reversWord="";
        //iterate through the string reversMe
        for (int i=0; i<reverseMe.length(); i++) {
            int index = i+1;
            reversWord= reversWord+word[reverseMe.length()-index];
        }
        return reversWord;

    }

}