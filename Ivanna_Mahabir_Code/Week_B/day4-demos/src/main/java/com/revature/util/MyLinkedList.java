package com.revature.util;

public class MyLinkedList<T> {

    //The root node of our linked list
    private Node<T> head;

    //The ending node of the linked list
    private Node<T> tail;

    /**
     * Inserts a new node, containing the provided data, at the end
     * of the linked list
     *
     * @param data
     */
    public void insert(T data){

        //create a new node object, whose next node value is null,
        // and contains the provided data.
        Node<T> newNode = new Node<>(data, null);

        //if the head of this list is null, then the new node
        // will become tge first and the last node of the list.
        if(this.head == null){
            System.out.println("List is empty.. adding first element");
            this.head = newNode;
            this.tail = newNode;
        }

        //if there are already elements in the list, then we will select
        //the tail, setting its next to node to the new one we created.
        else{
            System.out.println("List has contents...adding new node to the end");
            this.tail.setNextNode(newNode); //setting the new tail as the new Node we created
            this.tail = newNode; // settin the reference of the old tail to the new Node.
        }
    }

    /**
     * Returns, but does not remove the first items in the list
     *
     * @return
     */
    public T peek(){
        if(this.head != null){
            return this.head.getData();
        }
        return null;
    }

    /**
     * Returns, and removes the first item in the linked list.
     *
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
     * Removes the first occurrence of the provided key in the linked list
     *
     * @param key
     * @return
     */
    public boolean removeByKey(T key){
        //if data == k, then remove node
        //handle the scenario where list is empty
        if(this.head == null){
            return false;
        }
        //create a reference to hold the current node
        Node<T> currentNode =  this.head;

        //create a reference to hold the next node (after currentNode)
        Node<T> nextNode = currentNode.getNextNode();

        //if the first node contains data equal to the key ,remove that node
        if(currentNode.getData().equals(key)){
            this.head = nextNode;
            return true;
        }
        // iterate across the linked list while currentNode is not equal to null
        while(currentNode != null){
            // if the nestNode is not null and contains the data we want to delete
            // then have the currentNode point to the node after nextNode
            if(nextNode != null && nextNode.getData().equals(key)){
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }

            // advance currentNode to the next node in the list
            currentNode = currentNode.getNextNode();

            //if nextNode is not null, then advance nextNode to the one after it
            if(nextNode != null){
                nextNode = nextNode.getNextNode();
            }
        }

            return false;
    }

    /**
     * Convenience method for printing List's contents.
     */
    public void printList(){
        //Start with the head of the list
        Node<T> currentNode = this.head;

        //While the current node is not null, print out node info and move onto the next.
        while(currentNode != null){
            System.out.println("Node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }
}
