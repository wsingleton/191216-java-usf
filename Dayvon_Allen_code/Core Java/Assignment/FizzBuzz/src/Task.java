import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    public String[] fizzBuzz(int[] values) {

        if(values == null || values.length < 0){
            return new String[0];
        }

        String[] answerArr = new String[values.length];

        for (int i = 0; i < values.length; i++)
        {

            if(values[i] % 3 == 0 && values[i] % 5 == 0){
                answerArr[i] = "fizzbuzz";
            }
            else if(values[i] % 3 == 0){
                answerArr[i] = "fizz";
            }
            else if(values[i] % 5 == 0){
                answerArr[i] = "buzz";
            }
            else {
                answerArr[i] = Integer.toString(values[i]);
            }
        }

        return answerArr;

    }

}