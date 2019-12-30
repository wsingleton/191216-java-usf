package com.revature;

import javax.xml.soap.Node;

public class MyBinaryTree {

    private TreeNode root;

    public void add(Integer value) {

    }

    private TreeNode addRecursively(TreeNode currentNode, Integer value) {
        //if the null passed to this method is null, return a new node containing the value
        if(currentNode == null) {
            System.out.println("The current node is null, creating new node to add to tree...");
            return new TreeNode(value);
        }

        /*
            If the value being added is less than the value of the current node, then recursively
            invoke this method (addRecursively) to attempt to add a new value to the left child
            of the current node.
         */
        if(value < currentNode.getData()) {
            System.out.println("The new value is less than the current node's value.");
            System.out.println("Attempting to add a new value to the left child node.");
            TreeNode temp = addRecursively(currentNode.getLeftChild(), value);
            currentNode.setLeftChild(temp);
        }

        else if (value > currentNode.getData()) {
            System.out.println("The new value is greater than the current node's value");
            System.out.println("Attempting to add a new value to the right child node.");
        }

        /*
            If the value being added is neither less or greater than the value of the current
            Node, simply return the current node.
         */
        return currentNode;
    }

    public boolean containsValueRecursively(TreeNode currentNode, Integer value) {
        /*
            If the current node is null, then the soughjt value is not stored within the
            tree, so return false
         */
        if (currentNode == null) {
            return false;
        }
        /*
            If the value contained within the current node is equal to the sought value,
            return true.
         */
        if (value.equals(currentNode.getData())) {
            return true;
        }
        /*
            If the sought value is less than the value of the current node, then we know
            that we need to explore the nodes to the left of the current node.
            Likewise, if the sought value is greater than the value of the current node, then
            we know that we need to explore the nodes to the right of the current node.
         */
        // ternary version can be found below!
//        if (value < currentNode.getData()) {
//            return containsValueRecursively(currentNode.getLeftChild(), value);
//        } else {
//            return containsValueRecursively(currentNode.getRightChild(), value);
//        }
        return (value < currentNode.getData()) ?
                containsValueRecursively(currentNode.getLeftChild(), value)
                :
                containsValueRecursively(currentNode.getRightChild(), value);
    }
}
