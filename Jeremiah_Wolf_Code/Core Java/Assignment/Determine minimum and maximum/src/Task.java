import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] minMax = new int[2];
        minMax[0] = minMax[1] = arr[0];
        for (int value : arr) {
            if (value < minMax[0]) minMax[0] = value;
            if (value > minMax[1]) minMax[1] = value;
        }
        return minMax;
    }
}