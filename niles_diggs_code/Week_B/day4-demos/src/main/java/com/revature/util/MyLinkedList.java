package com.revature.util;

public class MyLinkedList<T> {

    // root node of our linked list
    private Node<T> head;

    // the ending node of our linked list
    private Node<T> tail;

    /**
     * Inserts a new node, containing the provided data, at the end of the
     * linked list.
     * @param data
     */

    public void insert(T data) {

         /*
        create a new node object, whose nextNode value is null, and contains
        the provided data
         */

        Node<T> newNode = new Node<T>(data,null);

        /*
        if the head of this linked list is null, then the new node will become
        the first and the last of the list
         */
        if (this.head == null) {
            System.out.println("List is empty... adding first element");
            this.head = newNode;
            this.tail = newNode;
        }

        /*
        if there are already elements in the list, then we will select the tail,
        setting its next node to the new one we just created.
         */
        else {
            System.out.println("List has contents...adding new node to the end");
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }

    }

    /**
     * returns but does not remove, the first item in the list
     * @return
     */
    public T peek() {
        if (this.head != null) {
            return this.head.getData();
        }
        return null;
    }


    /**
     * returns, and removes, the first item in the linked list
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

    public boolean removeByKey(T key) {
        /*
        Must look for a key in each node and if found remove it

        -process : for each node in, look for key in node
        if key is found, get data and remove,
        else move to next node
         */

        // for (Node<T> n : MyLinkedList) - working this out later
        //Create a reference to hold the current node
        Node<T> currentNode = this.head;

        //Create a reference to hold the next node
        Node<T> nextNode = currentNode.getNextNode();

        // if the first node contains data equal to a key, remove that node
        if (currentNode.getData().equals(key)) {
            this.head = nextNode;
            return true;
        }


        //iterate across the linked list while the currentNode is not null
        while (currentNode != null) {

            /*
            if the next node is not null and contains the data we want to
            delete then have the currentNode point to the node after nextNode
             */

            if (nextNode != null && nextNode.getData().equals(key)) {
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }

            // advance current node to the next node in the list
            currentNode = currentNode.getNextNode();

            //if next node is not null, then advance the next to the one after it
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

        //Start with the head of this list
        Node<T> currentNode = this.head;

        //While the current node is not null, print out node info and move on
        //the next

        while (currentNode != null) {
            System.out.println("Node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }
}
