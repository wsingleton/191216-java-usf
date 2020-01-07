package com.revature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.pow;

public class MainDriver {

    public static void main(String[] args) {

        double principal = 100;
        double time = 3;
        double rate = .0725;
        double freq = 12;


            double value = 1;
            double power = time * freq;
            value += rate/freq;

            double val;
            val = pow(value, power);
            val *= principal;

        System.out.println(val);

            BigDecimal bigDick = new BigDecimal(val).setScale(2, RoundingMode.HALF_UP);

            double bigD = bigDick.doubleValue();
        System.out.println(bigD);


        }



}
