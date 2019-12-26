import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {


        int [] intArray = new int[2];
        int [] emptyArray = new int [0];

        if(arr == null || arr.length <1){
            return emptyArray;
        }

        int min = arr[0], max = arr[0];
        for(int i: arr){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }
        intArray[0] = min;
        intArray[1] = max;
        return intArray;

    }
}