import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if (arr == null || arr.length == 0)
            return new int[0];

        int[] maxMin = new int[2];
        int[] copy = Arrays.copyOf(arr, arr.length);
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
        maxMin[0] = copy[0];
        maxMin[1] = copy[copy.length - 1];

        return maxMin;


    }
}