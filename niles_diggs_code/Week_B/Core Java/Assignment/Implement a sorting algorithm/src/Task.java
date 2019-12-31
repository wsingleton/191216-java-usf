import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        // Ripping your bubble sort Wez, sorry not sorry
            // handle the edge cases
            if (numbersForSorting== null || numbersForSorting.length == 0) {
                return new int[0];
            }
            try {

            for (int i = 0; i < numbersForSorting.length - 1; i++) {
                for (int j = i + 1; j < numbersForSorting.length; j++) {
                    if (numbersForSorting[i] > numbersForSorting[j]) {
                        int temp = numbersForSorting[j];
                        numbersForSorting[j] = numbersForSorting[i];
                        numbersForSorting[i] = temp;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return numbersForSorting;
        }
    }
