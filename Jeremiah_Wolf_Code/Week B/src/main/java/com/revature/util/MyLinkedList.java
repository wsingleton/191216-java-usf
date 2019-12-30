package com.revature.util;

public class MyLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    /**
     * Adds
     * @param data
     */

    public void insert(T data) {
        //create a new node object whos next node value is null and contains the provided data
        Node<T> newNode  = new Node<>(data, null);
        //if the head of this linked list is null, then the new node will become the first and last node of the list
        if (head == null){
            System.out.println("List is empty...adding first");
            head = newNode;
            tail = newNode;
        }
        // if there are already elements in the list, then we will select the tail setting its next node to new one we just created.\
        else {
            System.out.println("List has contents...adding new node adding to end");
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    /** returns, but does not remove, the first item in the list
     *
     * @return
     */

    public T peek () {

        if (head != null) {
            return head.getData();
        }

        return null;
    }

    /** returns, and removes the first item in the list.
     *
     * @return
     */

    public T poll () {

        Node<T> firstNode = head;

        if (firstNode != null) {
            head = head.getNextNode();
            return firstNode.getData();
        }

        return null;
    }

    /**removes the first occurence of the provided key in the linked list
     *
     * @param key
     * @return
     */

    public boolean removeByKey (T key){

        if (head == null) {
            return false;
        }

        // Create reference to current node
        Node<T> currentNode = head;

        // Create a reference to hold next node
        Node<T> nextNode = currentNode.getNextNode();

        // if first node = data of key remove that node
        if (currentNode.getData().equals(key)) {
            head = nextNode;
            return true;
        }

        //iterate across the linked list while currentNode is not null
        while (currentNode != null) {

            // if next node is not null and contains the key then have currentNode point to the node after the nextNode
            if (nextNode != null && nextNode.getData().equals(key)) {
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }

            // advance currentNode to the nextNode in the list
            currentNode = currentNode.getNextNode();

            // if nextNode is not null, then advance next to the one after it
            if (nextNode != null) {
                nextNode = nextNode.getNextNode();
            }
        }

        return false;
    }

    /**
     * Convience method for printing our list's contents
     */
    public void printList() {
        // start with the head of the list
        Node<T> currentNode = head;

        // While the current node is not null, print out info and move onto next
        while(currentNode != null) {
            System.out.println("Node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

}
