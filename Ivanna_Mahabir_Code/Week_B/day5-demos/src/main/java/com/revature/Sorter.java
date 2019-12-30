package com.revature;

import javax.sound.midi.Soundbank;

public class Sorter {

    public int[] bubbleSorter(int[] candidateArray){

        // handle the edge cases
        if(candidateArray == null || candidateArray.length == 0){
            return new int[0];
        }

        for(int i = 0; i < candidateArray.length-1; i++){
            for(int j = i+1; j < candidateArray.length; j++){
                if(candidateArray[i] > candidateArray[j]){
                    int temp = candidateArray[j];
                    candidateArray[j] = candidateArray[i];
                    candidateArray[i] = temp;
                }
            }
        }
        
        return candidateArray;
    }
/*    public void printArray(int[] arr){
        for(int i: arr) System.out.println(i);

    }*/
}
