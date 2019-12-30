import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        for (int i = 0;i < arr.length - 1;i++ ){
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
        int[] minMax = {arr[arr.length-1], arr[0]};
        return minMax;
    }
}