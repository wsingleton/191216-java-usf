import java.util.Arrays;

public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values == null){
            return new String[0];
        }
        String [] answer = new String[0];
        int i = 0;
        for (int x:
             values) {
            if(x%3 == 0 && x%5 ==0){
                answer = Arrays.copyOf(answer, answer.length+1);
                answer[i] = "fizzbuzz";
            }else if(x%3 == 0){
                answer = Arrays.copyOf(answer, answer.length+1);
                answer[i] = "fizz";
            }else if(x%5 == 0){
                answer = Arrays.copyOf(answer, answer.length+1);
                answer[i] = "buzz";
            }else{
                answer = Arrays.copyOf(answer, answer.length+1);
                Integer integer = new Integer(x);
                answer[i] = integer.toString();
            }
            i++;

        }
        return answer;

    }

}