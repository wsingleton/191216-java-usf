package com.revature.util;

public class MyBinaryTree {

    private TreeNode root;

    public void add(Integer value) {
        this.root = addRecursively(this.root, value);
    }

    private TreeNode addRecursively(TreeNode currentNode, Integer value) {
        // if the node passed to this method is null, return a new node containing the value
        if (currentNode == null) {
            return new TreeNode(value);
        }

        /*
            if the value being added is less than the value of th current node, then recursively
            invoke this method (addRecursively) to attempt to add a new value to the left child of the current node
         */

        if (value < currentNode.getData()) {
            System.out.println("The new value is less than the current node's value");
            System.out.println("Attempting to add a new value to the left child node");
            currentNode.setLeftChild(addRecursively(currentNode.getLeftChild(), value));
        }

          /*
            if the value being added is less than the value of th current node, then recursively
            invoke this method (addRecursively) to attempt to add a new value to the left child of the current node
         */

        else if (value > currentNode.getData()) {
            System.out.println("The new value is less than the current node's value");
            System.out.println("Attempting to add a new value to the left child node");
            currentNode.setRightChild(addRecursively(currentNode.getRightChild(), value));

        }

    }

    public boolean containsValueR(Integer value) {

    }
}


