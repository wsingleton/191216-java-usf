import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        if(numbersForSorting == null || numbersForSorting.length == 0) {
            return new int[0];
        }

        int n = numbersForSorting.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbersForSorting[j] > numbersForSorting[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = numbersForSorting[j];
                    numbersForSorting[j] = numbersForSorting[j + 1];
                    numbersForSorting[j + 1] = temp;
                }
            }
        }
        System.out.println(" ");
        return numbersForSorting;
    }
}