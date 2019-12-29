import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if(arr == null || arr.length == 0){
            return new int[0];
        }
        int[] minMax = {3, 3};
        if(arr.length == 1){
            minMax[0] = arr[0];
            minMax[1] = arr[0];
            return minMax;
        }
        for (int i = 0; i < arr.length; i++){
            if(minMax[0] == 3 && i == 0){
                minMax[0] = arr[i];
            }
            else if(minMax[1] == 3 && i == 0 ){
                minMax[1] = arr[i];
            }
            for (int j = 0; j < arr.length; j++){
                if(arr[i] <= minMax[0]){
                    minMax[0] = arr[i];
                }
                else if(arr[i] >= minMax[1]){
                    minMax[1] = arr[i];
                }
            }
        }
        return minMax;
    }
}