import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {


    public int[] sortNumbers(int[] numbersForSorting) {


        if (numbersForSorting == null || numbersForSorting.length == 0) {
            return new int[0];
        }
        int[] arr = Arrays.copyOf(numbersForSorting, numbersForSorting.length);
        int n = arr.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if (arr[j - 1] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                });
        return arr;

    }
}
        /*


             
         */


