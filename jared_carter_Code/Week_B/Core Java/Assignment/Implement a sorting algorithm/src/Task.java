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
              public int[] bubbleSorter(int[] candidateArray) {

        if (candidateArray == null || candidateArray.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < candidateArray.length - 1; i++) {
            for (int j = i + 1; j < candidateArray.length; j++) {
                if (candidateArray[i] > candidateArray[j]) {
                    int temp = candidateArray[j];
                    candidateArray[j] = candidateArray[i];
                    candidateArray[i] = temp;
                }
            }
        }

        return candidateArray;

    }


         */


