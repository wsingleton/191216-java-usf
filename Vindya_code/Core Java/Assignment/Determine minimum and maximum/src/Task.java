import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int max = arr[0];
        int min = arr[0];
        for(int i: arr){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        int[] list = {min,max};
        return list;
    }
}