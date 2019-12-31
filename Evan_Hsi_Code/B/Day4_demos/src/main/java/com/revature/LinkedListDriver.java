package com.revature;

import com.revature.util.MyLinkedList;

public class LinkedListDriver {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.printList();
        System.out.println(linkedList.removeByKey(6));
        System.out.println("---------------------------");
        linkedList.printList();
    }
}
