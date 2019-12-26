package com.revature;

/*
In this class we use placeholder <T> to show that this class is of a particular type that we will define later.
This is called Generic. It removes the need to define what the var should be. eg. string, int, double.
 */

public class Node<T>{

    private T data;
    private Node <T> nextNode;

    public Node (T info, Node<T> next){
        this.data = info;
        this.nextNode = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

}
