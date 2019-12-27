package com.revature.util;

public class MyLinkedList<T> {
    // the root node of our linked list
    private Node<T> head;

    //the ending node of our linked list
    private Node<T> tail;



    /**
    insert a new node, containing the provided data at the end
     of the linked list
     @param
     */
    public void insert(T data){
// create a new node object whose nextNode value is null and contains
//        the provided data
        Node<T> newNode = new Node<T>(data, null);
//                if the head of this linked list is null then the new node will become the first and last node of the list
        if(this.head == null){
            System.out.println("List is empty.. adding first");
            this.head = newNode;
            this.tail = newNode;
        }
//                if there are already elements in the list, then we will select the tail, setting its next to node to the new one we just created
    else{System.out.println("list has contents adding new node to the end");
    this.tail.setNextNode(newNode);
    this.tail = newNode;
    }
    }

    /**
     * returns, but does not remove the first item in the list.
     * @return
     */
    public T peek(){
        if (this.head != null){
            return this.head.getData();
        }
        return null;
    }

    /**
     * Returns and removes the first item in the Linked list
     * @return
     */
    public T poll(){
        Node<T> firstNode = this.head;
        if (firstNode != null){this.head = this.head.getNextNode();
        return firstNode.getData();}

    return null;

    }

    /**
     * Removes the first occurance of the provided key in the linked list
     * @param key
     * @return
     */
    public boolean removeByKey(T key){
        Node<T> rmkey = this.head;
        Node<T> newNode = rmkey.getNextNode();
        //if the first node contains data equal to the key, remove that node
        if(rmkey.getData().equals(key)){
            this.head = newNode;
            return true;
        }
        // iterate across the linked list while current node is not null
        while(rmkey != null){

            //if the next node is not null and contains the data we want to delete
            //then have the current node point to the next node after next node
            if(newNode != null && newNode.getData().equals(key)){
                rmkey.setNextNode(newNode.getNextNode());
                return true;
            }
            //advance current node to the next node in the list
            rmkey = rmkey.getNextNode();

            // if next is not null, then advance the next to the one after it
            if(newNode != null){
                newNode = newNode.getNextNode();
            }
        }
        return false;
        }




    public void printList(){
// start with the head of the list
        Node<T> currentNode= this.head;
        //Whle the current node is not null print out the node info and move on to the next
    while(currentNode != null) {
    System.out.println("Node value " + currentNode.getData());
    currentNode = currentNode.getNextNode();
    }
    }
}
