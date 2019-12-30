package com.revature;

public class MethodsToTest {

    public int[] determineMinAndMax(int[] copy) {

        if (copy == null || copy.length == 0) {
            return new int[0];
        }

        for (int i = copy.length-1;i >= 0;i-- ){
            for (int j = copy.length-1; j >= 0; j--) {
                if (copy[i] > copy[j]) {
                    int temp = copy[j];
                    copy[j] = copy[i];
                    copy[i] = temp;
                }
            }

        }
        return copy;
    }

    public String[] fizzBuzz(int[] values) {

        String[] solution = new String[values.length];

        for (int i = 0; i < solution.length; i++) {
            if ((i + 1) % 3 == 0) {
                if ((i + 1) % 5 == 0) {
                    solution[i] = "fizzbuzz";
                } else {
                    solution[i] = "fizz";
                }
            }else if((i + 1) % 5 == 0){
                solution[i] = "buzz";
            } else {
                solution[i] = String.valueOf(values[i]);
            }
        }
        return solution;

    }


}

