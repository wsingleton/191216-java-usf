import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        /* Provide your implementation here */

        if ( arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] maxMin = {3, 3};

        if(arr.length == 1){
            maxMin[0] = arr[0];
            maxMin[1] = arr[0];
            return maxMin;

        }

        for (int i = 0; i < arr.length; i++){
            if(maxMin[0] == 3 && i == 0){
                maxMin[0] = arr[i];

            }
            else if(maxMin[1] == 3 && i == 0 ){
                maxMin[1] = arr[i];
            }

            for (int j = 0; j < arr.length; j++){
                if(arr[i] <= maxMin[0]){
                    maxMin[0] = arr[i];

                }

                else if(arr[i] >= maxMin[1]){
                    maxMin[1] = arr[i];
                }
            }
        }

        return maxMin;
    }
}