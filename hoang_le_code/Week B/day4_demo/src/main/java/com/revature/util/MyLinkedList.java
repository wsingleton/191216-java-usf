package com.revature.util;

public class MyLinkedList<T> {

    // the root node of our linked list
    private Node<T> head;

    //the ending node of our lnked list
    private Node<T> tail;


    /**
     * Insert a new node , containing the provided data, at the end
     * of the linked list
     *
     */
    public void insert(T data){
        // create a ner node objest, whose nextNode value is null, and
        //contain the provided data
        Node<T> newNode = new Node<>(data, null);


        //id the head of this linked list is null then the new nod
        // will become the first and the last node of the list
        if(this.head == null){

            System.out.println("list is empty");
            this.head = newNode;
            this.tail = newNode;

        }
        else {
            System.out.println("list has contents...aDDing new node to the end");
            this.tail.setNextNode(newNode);
            this.tail= newNode;
        }


        //if there are already elements in the list, then we will select the
        //tail, setting its next to node to the new one we just create

    }

    /**
     * Return but does not remove, the first intrm in the list

     */

    public T peek(){

        if (this.head != null){
            return this.head.getData();
        }
        return null;

    }


    /**
     * Return and remove the first item in the list
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
     * removes the first occurrence of the provided key in the list
     * @param key
     * @return
     */
    public boolean removeByKey(T key){

        if (this.head == null){
            return false;
        }

        //creaate current node
        Node<T> currentNode = this.head;

        // create a reference to hold the next node

        Node<T> nextNode = currentNode.getNextNode();

        if(currentNode.getData().equals(key)){
            this.head = nextNode;
            return true;
        }

        //interate accross the list while current not no eual to null

        while (currentNode != null){
            // if the nextNode is not null and contrains the data we want to delete
            // then have the currnetNode point to the node after next note
            if(nextNode !=null && nextNode.getData().equals(key)){
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }
            // advance current node to the next node in the list

            currentNode = currentNode.getNextNode();

            // if next node is not null , then advance the next to the one after it
            if (nextNode != null){
                nextNode = nextNode.getNextNode();
            }





        }
        return false;
    }


    /**
     * convenience method for printing out list,s contents
     */
    public void printList(){

        // start with the head of the list
        Node<T> currentNode = this.head;
        //White the current node is not null, print out node info move on the next

        while (currentNode != null){
            System.out.println("node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }
}
