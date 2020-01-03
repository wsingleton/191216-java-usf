import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        /* Provide your implementation here */
        // Check the base cases
        if(numbersForSorting == null || numbersForSorting.length == 0) {
            return new int[0];
        }

        // Make a copy of the original array, this copy will be sorted instead (functional)
        int[] arr = Arrays.copyOf(numbersForSorting, numbersForSorting.length);

        // Sort the array
        int n = arr.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if(arr[j -1] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                });

        return arr;

    }
}

