import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        /* Provide your implementation here */

        for (int i = 0; i <= numbersForSorting.length - 1; i++){
            for(int j=i+1; j <= numbersForSorting.length -1; j++){

                if (numbersForSorting[j]<numbersForSorting[i]){
                    int dummyV = numbersForSorting[j];
                    numbersForSorting[j] = numbersForSorting[i];
                    numbersForSorting[i] = dummyV;
                }
            }
        }

        return numbersForSorting;
    }
}











