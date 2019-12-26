package com.revature;

import com.revature.util.MyLinkedList;

public class LinkedListDriver {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<String>();
        myList.insert("insertString1");
        myList.insert("insertString2");
        myList.insert("insertString3");
        myList.insert("insertString4");
        myList.insert("insertString5");
        myList.insert("insertString6");
        myList.printList();

        System.out.println("+--------------------------------+");

        System.out.println(myList.peek());
        System.out.println(myList.peek());
        System.out.println(myList.poll());
        System.out.println(myList.poll());
        myList.printList();

        System.out.println("+--------------------------------+");

        myList.insert("removeByKey1");
        boolean bool = myList.removeByKey("removeByKey1");
        System.out.println("The first occurrence of value removeByKey was removed :: " + bool);
        myList.printList();
    }
}
