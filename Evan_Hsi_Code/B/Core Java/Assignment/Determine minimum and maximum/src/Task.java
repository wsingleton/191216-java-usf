import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if(arr == null || arr.length == 0) return new int[0];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        int[] mm = {min, max};
        return mm;
    }
}