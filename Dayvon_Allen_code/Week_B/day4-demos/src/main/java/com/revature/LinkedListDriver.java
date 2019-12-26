package com.revature;

import com.revature.util.MyLinkedList;

public class LinkedListDriver {

    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>();
        test.insert("Hello World");
        test.insert("Number 2");
        test.insert("Number 3");
        test.insert("Number 4");
        test.insert("Number 2");

        System.out.println("---------------------------");

        test.removeByKey("Number 2");
        test.printList();
    }

}
