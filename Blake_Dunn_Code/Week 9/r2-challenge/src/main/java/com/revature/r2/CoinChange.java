package com.revature.r2;

import java.util.List;

public class CoinChange {

    public static void main(String[] args) {


    }

    public static long checkEach(int n, List<Long> c) {

        long count = 0;

        for(int i = 0; i < c.size(); i++) {
            if (n % c.get(i) == 0) {
                count++;
            }
        }
        return count;
    }

    public static long checkCombos(int n, List<Long> c) {

        long count = 0;

        long total = 0;
        for(int i = 0; i < c.size(); i++) {
            for(int j = 0; j < c.size(); j++) {
                if(total < n) {
                    total = total + c.get(i);
                    if (total > n) {

                    }
                }
            }
        }

        return count;
    }

    public static long getWays(int n, List<Long> c) {

        long count = 0;
        c.sort(Long::compareTo);
        if(n == 0 || c.size() == 0) {
            return count;
        }
        count = checkEach(n, c);

        return count;
    }

}
