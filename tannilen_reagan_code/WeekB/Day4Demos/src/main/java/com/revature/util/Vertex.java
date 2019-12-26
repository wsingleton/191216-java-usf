package com.revature.util;

public class Vertex {
    private int data;
    private Vertex lChild;
    private Vertex rChild;

    public Vertex(int val) {
        this.data=val;
        lChild=null;
        rChild=null;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Vertex getlChild() {
        return lChild;
    }
    public void setlChild(Vertex lChild) {
        this.lChild = lChild;
    }
    public Vertex getrChild() {
        return rChild;
    }
    public void setrChild(Vertex rChild) {
        this.rChild = rChild;
    }
}
