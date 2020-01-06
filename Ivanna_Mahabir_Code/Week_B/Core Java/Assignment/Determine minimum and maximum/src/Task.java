import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if (arr == null || arr.length == 0 ) {
            return new int[0];
        }

        int[] minMax = new int[2];

        minMax[0] = minMax[1] = arr[0];
        for (int elem : arr) {
            if (elem < minMax[0]) {
                minMax[0] = elem;
            }
            if (elem > minMax[1]) {
                minMax[1] = elem;
            }
        }
        return minMax;


    }
}