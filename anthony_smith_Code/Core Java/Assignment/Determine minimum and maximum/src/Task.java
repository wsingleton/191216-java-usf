import java.util.Arrays;

public class Task {

    public int[] determineMinAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }


           int maxNumber = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > maxNumber) {
                    maxNumber = arr[i];
                }
            }

            int minNumber = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < minNumber) {
                    minNumber = arr[i];
                }
            }

           int[] minMaxArray= {minNumber, maxNumber};

            return minMaxArray;
        }

    }