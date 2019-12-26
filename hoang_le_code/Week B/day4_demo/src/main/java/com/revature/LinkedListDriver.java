package com.revature;

import com.revature.util.MyLinkedList;

public class LinkedListDriver {
    public static void main(String[] arge){

        MyLinkedList<String> stringList = new MyLinkedList<String>();
        stringList.insert("test 1");
        stringList.insert("test 2");
        stringList.insert("test 3");
        stringList.insert("test 4");
        stringList.insert("test 5");
        stringList.insert("test 6");
        stringList.printList();

        System.out.println("-----------------------");
        System.out.println(stringList.peek());
        System.out.println(stringList.peek());
        System.out.println(stringList.poll());
        System.out.println(stringList.poll());
        stringList.printList();

        System.out.println("-----------------------");
        String key = "test 5";
        stringList.insert("test 5");
        boolean wasRemove = stringList.removeByKey("test 5");

        System.out.println("the first occurent of value " + key + " was remove :: " + wasRemove);
        stringList.printList();




    }
}
