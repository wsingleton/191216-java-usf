package com.revature.revabooks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppDriver {

    public static void main (String[] args){
        System.out.println("Is it working?");

        Map<Integer, String> m = new HashMap<>();
        Integer key = 1;
        m.put(key, "Blake"); key++;
        m.put(key, "Bosco"); key++;
        m.put(key, "Ervin"); key ++;
        m.put(key, "Bosco"); key++;

        System.out.println(m.get(2));

        Iterator<Map.Entry<Integer, String>> mapEntries = m.entrySet().iterator();

        while (mapEntries.hasNext()){
            Map.Entry<Integer, String> entry = mapEntries.next();
            System.out.println("Entry: " +entry.getKey() + " Value " + entry.getValue());
        }

        // iterating using a foreach lambda expression
        System.out.println("---------------------------------------------------------");
        System.out.println("For each lambda expression to iterate over a map" + "\n");
        System.out.println("Map size = " + m.size());
        m.forEach((k,v) -> {
            if(v == "Bosco") {
                System.out.println("Key: " + k + ", " + "Value: " + v);
            }
        });

    }
}
