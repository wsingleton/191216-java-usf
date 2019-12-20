package com.revature;
import java.util.ArrayList;

public class ListDriver {
    public static void main(String[] args){
        ArrayList<String> strings=new ArrayList<>();
        strings.add("test");
        strings.add("test2");
        strings.add("test");
        for (String s : strings) {
            System.out.println(s);
        }
        for (int i=0; i<strings.size(); i++){
            System.out.println(strings.get(i));
        }
    }
}
