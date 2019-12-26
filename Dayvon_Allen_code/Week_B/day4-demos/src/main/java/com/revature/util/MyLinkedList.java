package com.revature.util;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * This is acustom implementation of a linked list data structure,
 * which vaguely mirrors the java collections API implementation of a LinkedList.
 * @param <T>
 */
public class MyLinkedList<T> {

    //the root node of our linked list
    private Node<T> head;

    //the ending node of our linked list
    private Node<T> tail;

    /**
     *  Insert a new node, containing the provided data, at the end of the linked list.
     * @param data
     */
    public void insert(T data){

        // create a new node object, whose next node's value is null and contains the provided data
        Node<T> node = new Node<>(data, null);

        //if the head of this linkedlist is null then the new node will become the first and last node
        if(head == null){
            System.out.println("List is empty...adding first element.");
            this.head = node;
            this.tail = node;
        }
        //if there are already elements in the list, then we will select the tail, setting its next node to the new one we just created
        else {
            System.out.println("List has contents...adding new node to the end");
            tail.setNextNode(node);
            tail = node;
        }

    }

    /**
     * returns, but does not remove first item in the list.
     * @return
     */
    public T peek() {

        if(this.head != null){
            return this.head.getData();
        }
        return null;
    }

    /**
     * returns and remove first item in the list.
     * @return
     */
    public T poll(){

        Node<T> firstNode = this.head;

        if(firstNode != null){
            this.head = this.head.getNextNode();
            return firstNode.getData();
        }

        return null;
    }

    /**
     * removes the first occurence of the provided key in the linked list.
     * @param key
     * @return
     */
    public boolean removeByKey(T key) {
        Node<T> currentNode = this.head;
        Node<T> nextNode = currentNode.getNextNode();
        //gets rid of the first one
        if(currentNode.getData().equals(key)) {
            this.head = nextNode;
            return true;
        }
        //for other ones
        while (this.head != null){
            if(nextNode != null && nextNode.getData().equals(key))
            {
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }
            currentNode = currentNode.getNextNode();

            if(nextNode != null){
                nextNode = nextNode.getNextNode();
            }
            if(currentNode == null){
                return false;
            }
        }
        return false;
    }

    /**
     * Convenience method for printing our list's contents
     */
    public void printList(){

        //start with the head of the list
        Node<T> currentNode = this.head;

        while (currentNode != null){
            System.out.println("Node Value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }


}
