package com.revature.util;

/**
 * Custom implementation of the LinkedList functionality of the Java Collections API implementation.
 * @param <T>
 * @author Tannilen Reagan
 */
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    /**
     * Inserts a new node containing the provided data at the end of the linked list.
     * @param data
     */
    public void insert(T data) {
        Node<T> newNode=new Node<T>(data, null);
        if (this.head==null) {
            System.out.println("List is empty.  Populating new list.");
            this.head=newNode;
            this.tail=newNode;
        }
        else {
            System.out.println("Adding new data to list.");
            this.tail.setNextNode(newNode);
            this.tail=newNode;
        }
    }
    /**
     * Returns the first item in the linked list without removing it.
     * @return
     */
    public T peek () {
        if (this.head != null) {
            return this.head.getData();
        } else {
            return null;
        }
    }
    /**
     * Returns and removes the first item in the linked list.
     * @return
     */
    public T poll () {
        Node<T> first=head;
        if (first!=null){
            this.head=this.head.getNextNode();
            return first.getData();
        }
        else {
            return null;
        }
    }
    /**
     * Removes the first occurrence of the provided key in the linked list.
     * @param key
     * @return
     */
    public boolean removeByKey(T key) {
        Node<T> prev=null;
        Node<T> current=this.head;
        while (current!=null) {
            if (current.getData() != key) {
                System.out.println("Value " + current.getData() + " does not correspond to key " + key +".");
                prev = current;
                current = current.getNextNode();
            }
            else if (prev!=null){
                System.out.println("Value " + current.getData() + " corresponds to key " + key + ". Removing data.");
                prev.setNextNode(current.getNextNode());
                if (prev.getNextNode()==null) {
                    this.tail=prev;
                }
                System.out.println("Data removed.");
                return true;
            }
            else if (prev==null) {
                System.out.println("Value " + current.getData() + " corresponds to key " + key + ". Removing data.");
                this.head=current.getNextNode();
                System.out.println("Data removed.");
                return true;
            }
        }
        System.out.println("Data not found.");
        return false;
    }
    /**
     * Convenience method for the printing of list objects.
     */
    public void printList() {
        Node<T> current = this.head;
        while (current!=null) {
            System.out.print(current.getData() + " ");
            current=current.getNextNode();
        }
        System.out.println("");
    }
}
