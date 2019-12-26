package com.revature.util;

/**
 * This is a custom implementatioin of a linked list data structure, which
 * vaguely mirrors the Java Coollections API implementation of a LinkedList
 *
 * @param <T>
 */
public class MyLinkedList<T> {

    // The root node of our linked list
    private Node<T> head;

    // The ending node of our linked list
    private Node<T> tail;

    /**
     * Inserts a new node, containing the provided data, at the end
     * of the linked list.
     * @param data
     */
    public void insert(T data) {


        // create a new node object, whose nextNode value is null, and
        // contains the provided data.

        Node<T> newNode = new Node<>(data, null);

        // if the head of this linked list is null, then the new node
        // will become the first and the last node of the list
        if(this.head == null) {
            System.out.println("List is empty...adding first element");
            this.head = newNode;
            this.tail = newNode;
        }

        // if there are already elements in the list, then we will select the
        // tail, setting its next to node to the new one we just created.
        else {
            System.out.println("List has contents...adding new node to the end");
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }

    }

    /**
     * Returns, but does not remove, the first item in the list
     *
     * @return
     */
    public T peek() {

        if(this.head != null) {
            return this.head.getData();
        }

        return null;
    }

    /**
     * Returns, and removes, the first item in the linked list
     * @return
     */
    public T poll() {

        Node<T> firstNode = this.head;

        if (firstNode != null) {
            this.head = this.head.getNextNode();
            return firstNode.getData();
        }

        return null;

    }

    /**
     * Removes the first occurrence of the provided key in the linked list
     *
     * @param key
     * @return
     */
    public boolean removeByKey(T key) {
        if (this.head == null) {
            return false;
        }

        Node<T> newNode = this.head;

        Node<T> nextNode = newNode.getNextNode();

        // If the first node contains data equal to the key, remove that node
        if (newNode.getData().equals(key)) {
            this.head = nextNode;
            return true;
        }

        while (newNode != null) {

            // If the nexNode is not null and contains the data we want to delete
            // then have the currrentNode point to the node after nextNode
            if (nextNode != null && nextNode.getData().equals(key)) {
                newNode.setNextNode(nextNode.getNextNode());
                return true;

            }
                // advance newNode to the next node in the list
                newNode = newNode.getNextNode();

            if (nextNode != null) {
                nextNode = nextNode.getNextNode();
            }

        }
        return false;
    }

    /**
     * Convenience method for printing our list's contents
     */
    public void printList() {

        // Start with the head of the list
        Node<T> currentNode = this.head;

        // While the current node is not null, print out node info and move onto the next
        while (currentNode != null) {
            System.out.println("Node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }


}
