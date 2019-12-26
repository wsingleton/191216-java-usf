import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        int [] answer = new int[numbersForSorting.length];
        answer[0] = numbersForSorting[0];
        int holder = 0;
        for(int i = 1; i < numbersForSorting.length; i++){
            if (numbersForSorting[i] < answer[i-1]){
                holder = answer[i-1];
                answer[i-1] = numbersForSorting[i];
                answer[i] = holder;
            }
        }
        return answer;

    }
}