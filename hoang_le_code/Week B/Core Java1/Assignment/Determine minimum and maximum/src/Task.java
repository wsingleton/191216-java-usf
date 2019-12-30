import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int min = arr[0];
        int max = arr[0];
        for (int u: arr) {
            if (u < max) {
                max = u;
            }
            if (u > min) {
                min= u;
            }
        }
        int[] contain = new int[2];
        contain[0] = max;
        contain[1]= min;
        return contain;


    }
}