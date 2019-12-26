package com.revature.util;

public class Node<T> {

    // To leverage generics so that you can create different types of linked lists,
    // you can put a <T> in class name to act as a placeholder of a type that will be defined
    // later on.
    private T data;
    private Node<T> nextNode;

    public Node(T info, Node<T> next) {
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
