import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {

        if (arr == null || arr.length == 0)
            return new int[0]; // check for test cases that are null or empty

        // initialize a new array of two
        int[] minMax = new int[2];

        // Make each placeholder equal to first value of the original array
        minMax[0] = minMax[1] = arr[0];
        /*
            Iterate through the values of the array until you find the one that is
            that the min and max value of the array
         */
        for (int value : arr) {

            if (value < minMax[0]) minMax[0] = value;
            if (value > minMax[1]) minMax[1] = value;
        }

        return minMax;


    }
}