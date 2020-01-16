import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;
public class PracticeCode {
    int year;
    int leapyear;
    PracticeCode(){super();}

    public static boolean isLeapYear(int year,int leapyear) {
     if(year%leapyear == 0) {return true;}
        return false;
    }
    public static void main(String... args) {
        System.out.println(PracticeCode.isLeapYear(2002, 4));
    }
}

