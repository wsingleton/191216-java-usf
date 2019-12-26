package com.revature.util;

public class MyLinkedList<T> {

    //root node
    private Node<T> head;

    //end node
    private Node<T> tail;

    /**
     * adds a new node to the end of our list
     * @param data
     */
    public void insert(T data) {
        Node<T> ins = new Node(data, null);
        if(head == null) {
            head = ins;
        }
        else {
            tail.setNextNode(ins);
        }
        tail = ins;
    }

    /**
     * returns the first item in the linked list
     * @return
     */
    public T peek() {
        if(head != null) {
            return head.getData();
        }
        return null;
    }

    /**
     * returns and removes the first item in the list
     * @return
     */
    public T poll() {
        if(head != null) {
            T temp =  head.getData();
            head = head.getNextNode();
            return temp;
        }
        return null;
    }

    /**
     * removes the first occurrence of the provided key in the linked list, returns false if not found
     * @param key
     * @return
     */
    public boolean removeByKey(T key) {
        if(head == null) return false;
        Node<T> iter = head;
        Node<T> pre = head;
        if(head.getData().equals(key)) {
            head = head.getNextNode();
        }
        iter = head.getNextNode();
        while(iter != null) {
            if(iter.getData().equals(key)) {
                pre.setNextNode(iter.getNextNode());
                return true;
            }
            iter = iter.getNextNode();
            pre = pre.getNextNode();
        }
        return false;
    }

    public void printList() {
        Node<T> iter = head;
        while(iter != null) {
            System.out.println(iter.getData());
            iter = iter.getNextNode();
        }
    }


}
