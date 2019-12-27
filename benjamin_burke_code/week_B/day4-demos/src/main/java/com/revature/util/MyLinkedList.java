package com.revature.util;

/**
 * This is a custom implementation of a linked list data structure, which
 * vaguely mirrors the java Collections Api implementation of Linked list
 * @param <T>
 */

public class MyLinkedList<T> {

    // The root node of out linked list
    private Node<T> head;

    // The ending node of our linked list
    private Node<T> tail;

    /**
     * Inserts a new node, containing the provided data, at the end
     * of the linked list.
     *
     * @return
     */

    public void insert(T data) {

        //create a new node object, whose nextNode value is null, and
        //contains the provided data
        Node<T> newNode = new Node<>(data, null);

        //if the head of this linked list is null, then the new node
        //will become the first and the last node of the list
        if (this.head==null) {
            System.out.println("list is empty...adding first element");
            this.head = newNode;
            this.tail = newNode;
        }


        // if there are already elements in the list, then we will select the
        //tail, setting its next node to the new one that we just created.
        else {
            System.out.println("list has contents, adding new node to the end");
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }

    /**
     * Returns, but does not remove, the first item in the list.
     * @return
     */

    public T peek(){

        if (this.head !=null) {
            return this.head.getData();
        }

        return null;

    }

    /**
     * Returns, and removes, the first item in the linked list.
     *
     * @return
     */
    public T poll(){

        Node<T> firstNode = this.head;

        if(firstNode !=null){
            this.head = this.head.getNextNode();
            return firstNode.getData();
        }

        return null;

    }

    /**
     * Removes the first occurrence of the provided key in the linked list.
     * @param key
     * @return
     */
    public boolean removeByKey(T key){
        Node<T> currentNode = this.head;
        Node<T> nextNode=currentNode.getNextNode();
        //handle the scenario where the list is empty
        if(this.head==null){
            return false;
        }
        // If the first node contains data equal to the key, remove that node
        if (currentNode.getData().equals(key)) {
            this.head = nextNode;
            return true;
        }

        // iterate across the linked list while currentNode is ot null
        while (currentNode != null){
            // If the nextNode is not null and contains the data we want to delete
            //then have the currentNode point to the node after the nextNode
            if (nextNode !=null && nextNode.getData().equals(key)){
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }

            //advance currentNode to the next node in th elist
            currentNode = currentNode.getNextNode();

            // if nexNode is !null, then advance to the next to the one after it
            if (nextNode !=null){
                nextNode = nextNode.getNextNode();
            }
        }
        return false;
    }

    /**
     * Convenience method for printing our list's contents
     */
    public void printList(){

        // Start with the head of the list
        Node<T> currentNode = this.head;

        //While the current node is not null, print out node info and move on the next
        while (currentNode != null) {
            System.out.println("node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }

}
