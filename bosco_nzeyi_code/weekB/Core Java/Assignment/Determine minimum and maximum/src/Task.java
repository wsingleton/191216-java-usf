import java.lang.reflect.Array;
import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        int [] minMax = new int[2];
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        minMax[0]= arr[0];
        minMax[1] = arr[arr.length - 1];
        return minMax;

    }
}