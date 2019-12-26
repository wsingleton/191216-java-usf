package com.revature;

public class LinkedListDriver {

    public static void main (String[] args){

        MyLinkedList<String> stringlist = new MyLinkedList<String>();
        stringlist.insert("test 1");
        stringlist.insert("test 2");
        stringlist.insert("test 3");
        stringlist.printList();

    }
}
