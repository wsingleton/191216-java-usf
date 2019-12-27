import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {
        int[] returnArray;
        if (arr==null) {
            returnArray=new int[0];
            return returnArray;
        }
        if (arr.length==0) {
            returnArray=new int[0];
            return returnArray;
        }
        int min=arr[0];
        int max=arr[0];
        for (int i : arr) {
            if (i<min) {
                min=i;
            }
            if (i>max) {
                max=i;
            }
        }
        returnArray=new int[2];
        returnArray[0]=min;
        returnArray[1]=max;
        return returnArray;
    }
}