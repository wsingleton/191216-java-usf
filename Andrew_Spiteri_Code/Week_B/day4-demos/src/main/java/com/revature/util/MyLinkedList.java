package com.revature.util;

import java.util.prefs.NodeChangeListener;

/**
 * This is a custom implementation of a linked list.
 * @param <T>
 */
public class MyLinkedList<T> {

    //root and ending nodes of LinkedList
    private Node<T> head, tail;
    /**
     * Inserts a new node, containing the provided data, at the end of the linked list.
     * @parm data
     */
    public void insert(T data){
        Node<T> node = new Node<>(data,null);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.setNextNode(node);
            this.tail = node;
        }
    }

    /**
     * Returns, but does not remove, the first item in the linked list.
     * @return
     */
    public T peek(){
        if(this.head != null){
            return this.head.getData();
        }
        return null;
    }

    /**
     * Returns and removes the first item in the linked list.
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
     * Removes 1st occurrence of the provided key in the linked list.
     * @parm key
     * @return
     */
    public boolean removeByKey(T key){
        //Handle case where the list is empty
        if(this.head == null){
            return false;
        }
        //Create reference to hold current node
        Node<T> node = this.head;
        //Create a reference to hold the next node (after currentNode)
        Node<T> nextNode = node.getNextNode();
        //If the first node contains data equal to the key remove that node
        if(node.getData().equals(key)){
            this.head = nextNode;
            return true;
        }
        //Iterate across the linked list while currentNode is not null
        while(node.getNextNode() != null){
            /*
                If the nextNode is not null and contains the data we want to delete
                then have the currentNode point to the node after nextNode
             */
            if(nextNode != null && nextNode.getData().equals(key)){
                node.setNextNode(nextNode.getNextNode());
                return true;
            }
            //advance node to next node in the list
            node = node.getNextNode();

            //if next node is not null, then advance the next to the one after it
            if(nextNode != null) nextNode = nextNode.getNextNode();
        }
        return false;
    }

    /**
     * Convenience method for printing our list's contents
     */
    public void printList(){
        // Start with the head of the list
        Node<T> currentNode = this.head;

        //while current node not null, print out current node and move on to next
        while(currentNode != null){
            System.out.println("Node value: "+currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

}
