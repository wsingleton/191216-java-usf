package com.revature.r2;

public class Luck {

    public static void main(String[] args) {
        int[][] arr = new int[7][2];
        int[] arr1 = {6,3,5,1,2,1,1,1,8,1,10,0,5,0};
        int j = 0;
        for(int i = 0; i < arr1.length;) {
            j++;
            for(int k = 0; k < 2; k++) {
                arr[j][k] = arr1[i++];
            }
            j++;
        }

        System.out.println(arr);
    }
}
