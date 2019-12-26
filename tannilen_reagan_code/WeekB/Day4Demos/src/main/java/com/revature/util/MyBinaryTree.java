package com.revature.util;

public class MyBinaryTree {
    private Vertex root;

    public void add(int val) {
        this.root=addRecursive(this.root, val);
    }
    private Vertex addRecursive(Vertex current, int val){
        if (current==null) {
            System.out.println("Adding value.");
            Vertex newVert=new Vertex(val);
            return newVert;
        }
        if (val < current.getData()) {
            System.out.println("Value " + val + " is less than " + current.getData() + ".");
            current.setlChild(addRecursive(current.getlChild(), val));
        }
        else if (val > current.getData()) {
            System.out.println("Value " + val + " is greater than " + current.getData() + ".");
            current.setrChild(addRecursive(current.getrChild(), val));
        }
        return current;
    }
    public boolean contains (int val) {
        return containsRecursively(this.root, val);
    }
    private boolean containsRecursively(Vertex current, int val){
        if (current==null) {
            System.out.println("Value not found.");
            return false;
        }
        if (val < current.getData()) {
            return containsRecursively(current.getlChild(), val);
        }
        if (val > current.getData()) {
            return containsRecursively(current.getrChild(), val);
        }
        if (val==current.getData()) {
            System.out.println("Value found.");
            return true;
        }
        return false;
    }
}
