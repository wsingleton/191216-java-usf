package com.revature;

public class Sorter {
    public int[] bubbleSorter(int[] candidateArray) {
        if (candidateArray==null || candidateArray.length==0) {
            return new int[0];
        }
        for(int i=0;i<candidateArray.length;i++) {
            for (int x=i+1;x<candidateArray.length;x++) {
                if (candidateArray[i]>candidateArray[x]) {
                    int n=candidateArray[x];
                    candidateArray[x]=candidateArray[i];
                    candidateArray[i]=n;
                }
            }
        }
        return candidateArray;
    }
}
