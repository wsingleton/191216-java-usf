import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        char[] charArray = reverseMe.toCharArray();
        CharSequence charSequence = new CharSequence() {
            @Override
            public int length() {
                return charArray.length;
            }

            @Override
            public char charAt(int index) {
                return charArray[index];
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return null;
            }
        };
        String answer = new String();
        for(int i = charArray.length - 1; i >= 0; i--){
            answer = answer + charSequence.charAt(i);
        }
        return answer;


    }



    }