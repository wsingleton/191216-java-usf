package com.revature;

import com.revature.util.MyLinkedList;

public class LinkedListDrive {
    public static void main(String... args){
MyLinkedList<String> stringList = new MyLinkedList<String>();
stringList.insert("test1");
        stringList.insert("test2");
        stringList.insert("test3");
        stringList.insert("test4");
        stringList.insert("test5");
        stringList.insert("test6");
        stringList.printList();

        System.out.println("+---------------------------+");
        System.out.println(stringList.peek());
        System.out.println(stringList.peek());
        System.out.println(stringList.poll());
        System.out.println(stringList.poll());
        stringList.printList();

        System.out.println("+----------------------------+");

        stringList.insert("test5");
        String key = "test5";
        boolean wasRemoved = stringList.removeByKey("test5");
        System.out.println("The first occurence of value " +key+ " was removed :: " + wasRemoved);
        stringList.printList();

    }
}
