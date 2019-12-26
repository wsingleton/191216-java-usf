package com.revature.util;

//parameterized type, T is a placeholder for data type
public class Node<T> {

    //parametric polymorphism(this class is, runtime polymorphism method overriding is as well)
    //covariance is subtypo polymorphism

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
