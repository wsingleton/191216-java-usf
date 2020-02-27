package com.revature;

import com.revature.challenge.Challenge;

public class Driver {

    public static void main(String[] args) {
        String[] a = {"CS", "CS", "SS", "SCCSSC", "CC", "CSCSS", "SSSS", "SSCS", "SSSSCCSSSSSSSSSSSCCCSSSS"};
        int[] s = {1, 2, 1, 6, 2, 3, 4, 2, 18};
        Challenge.evaluate(1, s[0], a[0]);
        Challenge.evaluate(2, s[1], a[1]);
        Challenge.evaluate(3, s[2], a[2]);
        Challenge.evaluate(4, s[3], a[3]);
        Challenge.evaluate(5, s[4], a[4]);
        Challenge.evaluate(6, s[5], a[5]);
        Challenge.evaluate(7, s[6], a[6]);
        Challenge.evaluate(8, s[7], a[7]);
        Challenge.evaluate(9, s[8], a[8]);

    }
}
