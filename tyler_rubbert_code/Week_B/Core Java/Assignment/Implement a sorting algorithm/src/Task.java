import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        if (numbersForSorting == null || numbersForSorting.length == 0) {
            return new int[0];
        }

        int[] copy = Arrays.copyOf(numbersForSorting, numbersForSorting.length);

        for (int i = copy.length-1;i >= 0;i-- ){
            for (int j = copy.length-1; j >= 0; j--) {
                if (copy[i] > copy[j]) {
                    int temp = copy[j];
                    copy[j] = copy[i];
                    copy[i] = temp;
                }
            }

        }
        return copy;
    }
}