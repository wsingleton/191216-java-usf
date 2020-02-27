package com.revature;

public class TestDriver {

    public static void main(String[] args) {
        int cases = 6;
        String[] a = {"CS", "CS", "SS", "SCCSSC", "CC", "CSCSS"};
        int[] s = {1, 2, 1, 6, 2, 3};
        Challenge.evaluate(1, s[0], a[0]);
//        System.out.println(Challenge.testShield(1, "CS"));
//        String a = "SCCSSC";
//        int i = a.length() - 1;
//        StringBuilder robot = new StringBuilder(a);
//        while (i > 0) {
//            if (robot.charAt(i) == 'S' && robot.charAt(i - 1) == 'C'){
//                char temp = robot.charAt(i);
//                robot.setCharAt(i, 'C');
//                robot.setCharAt(i-1, 'S');
//                i = a.length() - 1;
//                System.out.println(i);
//            }else{
//                i--;
//            }
//            System.out.println(robot);
//        }

    }

}
