package com.revature.util;

public class MyBinaryTree {
    private TreeNode root;

    public void add(Integer value){
        this.root = addRecursively(this.root,value);
    }

    private TreeNode addRecursively(TreeNode currentNode, Integer value){
        //if currentNode passed is null, return a new node containing the value
        if(currentNode == null){
            System.out.println("Current node is null...creating new node to add to tree.");
            return new TreeNode(value);
        }
        /*
            If the value being added is less than the value of the current node, then
            recursively invoke this method (addRecursively) to attempt to add a new
            value to the left child of the current node.
         */
        if (value < currentNode.getData()){
            System.out.println("The new value is less than the current node's value");
            System.out.println("Attempting to add a new value to the left chile node");
            TreeNode temp = addRecursively(currentNode.getLeftChild(), value);
            currentNode.setLeftChild(temp);

        }
        /*
            If the value being added is greater than the value of the current node, then
            recursively invoke this method (addRecursively) to attempt to add a new
            value to the right child of the current node.
         */
        else if(value > currentNode.getData()){
            System.out.println("The new value is greater than the current node's value");
            System.out.println("Attempting to add a new value to the right child node");
            currentNode.setRightChild(addRecursively(currentNode.getRightChild(), value));
        }
        /*
            If the value being added is equal to the current node, simply return current node.
         */
        return currentNode;
    }

    public boolean containsValue(Integer value){
        return containsValueRecursively(this.root, value);
    }

    public boolean containsValueRecursively(TreeNode currentNode, Integer value){

        /*
            If the current node is null then the sought value is not contained within the tree,
            so return false.
         */
        if(currentNode == null){
            return false;
        }
        /*
            If the value contained within the current node is equal to the sought value
            return true.
         */
        if(value == currentNode.getData()){
            return true;
        }
        /*
            If sought value is less than value of current node then we know that we need to explore
            the nodes to the left of the current node.

            Likewise, if sought value is greater than value of current node then we know that we need to explore
            the nodes to the right of the current node.
         */
//        if(value < currentNode.getData()){
//            return containsValueRecursively(currentNode.getLeftChild(),value);
//        }else {
//            return containsValueRecursively(currentNode.getRightChild(),value);
//        }
        return (value < currentNode.getData() ? containsValueRecursively(currentNode.getLeftChild(),value):
                containsValueRecursively(currentNode.getRightChild(),value));
    }

}
