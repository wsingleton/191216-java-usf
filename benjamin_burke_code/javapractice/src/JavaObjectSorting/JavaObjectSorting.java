package JavaObjectSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaObjectSorting {
    public static void main(String[] args) {

        //Sort primitives array like int array
        int[] intArr = {5,78,98,4,26,69};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        //sort String array
        System.out.println("--------------------------");
        String[] strArr = {"A", "B", "C", "D", "Z"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        System.out.println("---------------------------");
        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("C");
        strList.add("L");
        strList.add("G");
        strList.add("B");
        strList.add("S");
        Collections.sort(strList);
        for(String str: strList) System.out.println(" " +str);


    }
}
