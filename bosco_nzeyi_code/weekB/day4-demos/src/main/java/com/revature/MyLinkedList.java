package com.revature;

/**
 * This is a custom implementation of a linked list data structure.
 * @param <T>
 */
public class MyLinkedList<T> {
    private Node <T> head; // the root node of our linked list
    private Node <T> tail; // the ending node of our linked list

    /** Insert a new node containing data at the end of the list.
     *
     * @param data
     */
    public void insert (T data){
        // create a new node object, whose next node value is null, and contains data provided.
        Node <T> node = new Node<>(data, null);


        // if the head of the linked list is null, then the new node will become the first and the last node of the list
        if(this.head == null) {
            System.out.println("list is empty ..... adding first element");
            this.head = node;
            this.tail = node;

        }
        // if there are already elements in the list, then we will select the tail,
        // setting its next node to the new one we just created.
        else {
            System.out.println("List has contents ..... adding new node to the end");
            this.tail.setNextNode(node);
            this.tail = node;
        }

    }

    /**
     * Returns but does not remove the first item on the list.
     * @return
     */
    public T peek (){
        return null;
    }

    public boolean removeByKey (){
        return false;
    }

    /**
     * a convenient method to print the list.
     */
    public void printList(){

        // start with the head of the list.

        Node<T> currentNode = this.head;

        // while the current node is not null, printout node info and move to the next one.
        while (currentNode != null){
            System.out.println("Node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }
}
