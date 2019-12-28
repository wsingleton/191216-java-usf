package com.revature;

public class Sort {

    public int [] bubbleSorter(int[] candidateArray){

        // handle the edge cases

        if (candidateArray == null || candidateArray.length == 0){
            return new int[0];
        }
        for(int i = 0; i < candidateArray.length; i++){
            for(int j = i + 1; j < candidateArray.length; j++){
                if(candidateArray[i] > candidateArray[j]){
                    int temp = candidateArray[j];
                    candidateArray[j] = candidateArray[i];
                    candidateArray[i] = temp;
                }
            }
        }

        return candidateArray;
    }
}
