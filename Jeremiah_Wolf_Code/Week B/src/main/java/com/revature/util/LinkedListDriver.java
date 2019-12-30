package com.revature.util;

import com.revature.util.MyLinkedList;

public class LinkedListDriver {

    public static void main(String[] args) {
        MyLinkedList<String> stringList = new MyLinkedList<>();
        stringList.insert("test1");
        stringList.insert("test2");
        stringList.insert("test4");
        stringList.insert("test5");
        stringList.insert("test6");
        stringList.insert("test7");
        stringList.insert("test8");
        stringList.insert("test9");
        stringList.printList();

        System.out.println(" +------------------------------------+");

        System.out.println(stringList.peek());
        System.out.println(stringList.peek());

        System.out.println("+------------------------------------+");

        stringList.insert("test5");
        String key = "test5";
        boolean wasRemoved = stringList.removeByKey("test5");
        System.out.println("The first occurrence of value " + key + "was removed ::" +wasRemoved);
        stringList.printList();
    }

}
