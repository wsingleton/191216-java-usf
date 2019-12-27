import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        if (numbersForSorting == null || numbersForSorting.length == 0) {
            return new int[0];
        }

        int[] copy = Arrays.copyOf(numbersForSorting, numbersForSorting.length);
        // bubble sort implementation
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < copy.length - 1; i++) {
                if (copy[i] > copy[i+1]){
                    temp = copy[i];
                    copy[i] = copy[i+1];
                    copy[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return copy;

    }
}