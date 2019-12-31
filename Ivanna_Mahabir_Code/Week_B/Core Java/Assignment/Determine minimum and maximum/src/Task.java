import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {
        if (arr == null || arr.length == 1){
            return new int[0];
        }
        int[] minMax = null;
        if(arr.length >= 2){
            for(int i = 0; i < arr.length-1; i++){
                for(int j=i+1; j<arr.length; j++){
                    if(arr[i]>arr[j]){
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }

            minMax[0] = arr[0];
            minMax[1] = arr[arr.length];
            return minMax;
        }
        return new int[0];
    }
}