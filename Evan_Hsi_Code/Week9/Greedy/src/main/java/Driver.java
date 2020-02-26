import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    public class Driver {

        // Complete the maxMin function below.
        static int maxMin(int k, int[] arr) {
            Map<Integer, Integer> map = new Hashmap<>();
            for(int i : arr) {
                if(!map.containsKey(i)) {
                    map.put(i,0);
                }
                else if (map.get(i) == k) return 0;
                else map.put(i, (map.get(i))++);
            }

            int min = Integer.INT_MAX;
            int tempmin = Integer.INT_MAX;
            List<Integer> sortedArr = Arrays.asList(arr);
            sortedArr = sortedArr.sort();

            for(int i = 0; i < sortedArr.length - k; i++) {
                tempmin = minMax(sortedArr.subList(i, i+k-1));
                min = Math.min(tempmin, min);
            }

            return min;

            // List<List<Integer>> matrix = new ArrayList<ArrayList<>>();

            // for(int i = 0; i < sortedArr.length; i++) {
            //     for(int j = i + 1; j < sortedArr.length; j++) {
            //         matrix[i].add(sortedArr[i]-sortedArr[j]);
            //     }
            // }

            // for(int i = 0; i < matrix.length; i++) {
            //     for(int j = 0; j < matrix[i].length; j++) {
            //         tempMin = sumArray(matrix, n);
            //     }
            // }
        }

        private static int minMax(ArrayList<Integer> arrList) {
            int max = Integer.INT_MIN, min = Integer.INT_MAX;
            for(Integer a : arrList) {
                if(a > max) max = a;
                if(a < min) min = a;
            }
            return max - min;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                int arrItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                arr[i] = arrItem;
            }

            int result = maxMin(k, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }



