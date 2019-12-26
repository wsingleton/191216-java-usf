package com.revature.util;

public class MyBinaryTree {

    private TreeNode root;

    public void add(Integer value){
        this.root = addRecursively(this.root, value);
    }

    private TreeNode addRecursively(TreeNode currentNode, Integer value){
       //if the node passed to this method is null, return a new mode containing the value
        if(currentNode == null){
            System.out.println("The current node is null, creating new node to add to tree.");
            return new TreeNode(value);
        }

        /*
        If the value being added is less than the value of the current node, the recursively
        invoke this method (addRecursively) to attempt to add a new value to the left child
        of the current node
         */
        if(value < currentNode.getData()){
            System.out.println("The new value is less than the current node's value");
            System. out.println("Attempting to add a new value to the left child");

            //currentNode.setLeftChild(addRecursively(currentNode.getLeftChild(), value));
            // the above is the same as below
            TreeNode temp = addRecursively(currentNode.getLeftChild(), value);
            currentNode.setLeftChild(temp);
        }

        /*
        If the value being added is greater than the value of the current node, the recursively
        invoke this method (addRecursively) to attempt to add a new value to the right child
        of the current node
         */
        else if (value > currentNode.getData()) {
            System.out.println("The new value is greater than the current node's value");
            System.out.println("Attempting to add a new value to the right child");

            //currentNode.setLeftChild(addRecursively(currentNode.getLeftChild(), value));
            // the above is the same as below
            TreeNode temp = addRecursively(currentNode.getRightChild(), value);
            currentNode.setRightChild(temp);
        }
        /*
        if the value being added is neither less or greater than the value of the current node,
        simply return the current node
         */
        return currentNode;
    }

    public boolean containsValue(Integer value){
        return containsValueRecursively(this.root, value);
    }

    public boolean containsValueRecursively(TreeNode currentNode, Integer value){

        /*
        IF the current node is null, then the sought value is not stored within the
        tree, so return false
         */
        if(currentNode == null){
            return false;
        }
        // if the value contained within the current node is equal to ------------
        if(value.equals(currentNode.getData())){
            return true;
        }
        /*
        if the sought value is less than the value of the current node, the we know
        that we need to explore the nodes to the left of the current node.

        Likewise, if the sought value is greater than the value of the current node, the we know
        that we need to explore the nodes to the right of the current node.
         */
        // if-else version
     /*   if(value < currentNode.getData()){
            return containsValueRecursively(currentNode.getLeftChild(), value);
        }
        else{
            return containsValueRecursively(currentNode.getRightChild(), value)
        }*/
        return (value < currentNode.getData()) ?
                containsValueRecursively(currentNode.getLeftChild(),value)
                : containsValueRecursively(currentNode.getRightChild(),value);
    }



}
