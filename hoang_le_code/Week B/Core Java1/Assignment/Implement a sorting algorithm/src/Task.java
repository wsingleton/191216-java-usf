import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {
        int temp = 0 ;
        if(numbersForSorting == null || numbersForSorting.length == 0) {
            return new int[0];
        }

        for(int i = 0 ; i < numbersForSorting.length; i++){
            for(int j = i; j < numbersForSorting.length;  j++){
                if(numbersForSorting[i] > numbersForSorting[j]){
                    temp = numbersForSorting[i];
                    numbersForSorting[i] = numbersForSorting[j];
                    numbersForSorting[j] = temp;

                }
            }
        }

        return numbersForSorting;

    }
}