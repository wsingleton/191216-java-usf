package com.revature.util;

/**
 * This is a custom implementation of a linked list data structure, which
 * vaguely mirrors
 * @param <T>
 */

public class MyLinkedList<T> {

    // The root node of our linked list
    private Node<T> head;

    //The ending node of our linked list
    private Node<T> tail;


    /**
     * Insertsa a new node, containing the provided data, at the end
     * of the limited list.
     * @param data
     */
    public void insert(T data) {

        //creates a new node object, whose nextNode value is null, and
        // contains the provided data
        Node<T> newNode = new Node<>(data, null);



        // if the head of this linked list is null, then the new code
        // will become the first and the last node of the list
        if (this.head == null) {
            System.out.println("List is empty...adding first element");
            this.head = newNode;
            this.tail = newNode;
        }

        //if there are already elements in the list, then we will select the
        // tail, setting its next to node to the new one we just created.

        else {
            System.out.println("List has contents...adding new node to the end");
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }




    public T peek() {
        return null;

        /** Return, but does not remove, the first item in the linked list.
         *
         * @return
         */

        public
    }



}
