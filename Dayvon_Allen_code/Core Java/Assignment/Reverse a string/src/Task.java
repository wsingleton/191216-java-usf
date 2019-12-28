import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        if(reverseMe == "" || reverseMe == null){
            return "";
        }
        String answer = "";
        String[] test = reverseMe.split("");
        int counter = test.length - 1;
        for (String i :  test){
            System.out.println(test[counter]);
            answer += test[counter];
            counter--;
        }
        return answer;

    }

}