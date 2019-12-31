package com.revature;

public class Sorter {

    public int[] bubbleSorter(int[] candidateArray) {

        if(candidateArray == null || candidateArray.length == 0) {
            return new int[0];
        }

        int n = candidateArray.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (candidateArray[j] > candidateArray[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = candidateArray[j];
                    candidateArray[j] = candidateArray[j + 1];
                    candidateArray[j + 1] = temp;
                }
            }
        }
    print(candidateArray);
         System.out.println(" ");
        return candidateArray;
    }

    private void swap(int[] candidateArray, int i, int j) {
        int temp = candidateArray[j+1];
        candidateArray[j+1] = candidateArray[i];
        candidateArray[i] = temp;
    }

    private void print(int[] candidateArray) {
        for (int i : candidateArray) System.out.println(i);
    }


}
