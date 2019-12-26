package com.revature.util;

public class MyBinaryTree {

    private TreeNode root;

    public void add(Integer value){
        this.root = addRecursively(this.root, value);
    }
    //recursion is bad for space complexity is because it keeps making new scopes but keeps old scope(makes a new stack frame)
    // frames going away after method returns something. a stack frame is a delineation of scope within the JVM's stack memory
    private TreeNode addRecursively(TreeNode currentNode, Integer value){
        if(currentNode == null){
            System.out.println("The current node is null, creating new node to add to tree");
            return new TreeNode(value);
        }
        if (value < currentNode.getData()){
            System.out.println("The new value is less than the current node's value");
            System.out.println("Attempting to add a new value to the left child node");
            TreeNode temp = addRecursively(currentNode.getLeftChild(), value);
            currentNode.setLeftChild(temp);
        }
        else if (value > currentNode.getData()){
            System.out.println("The new value is greater than the current node's value");
            System.out.println("Attempting to add a new value to the right child node");
            TreeNode temp = addRecursively(currentNode.getRightChild(), value);
            currentNode.setRightChild(temp);
        }

        return currentNode;
    }

    public boolean containsValue(Integer value){
        return containsValueRecursively(this.root, value);
    }

    public boolean containsValueRecursively(TreeNode currentNode, Integer value) {


        if (currentNode == null){
            return false;
        }

        if(value.equals(currentNode.getData())){
            return true;
        }

        return (value < currentNode.getData()) ? containsValueRecursively(currentNode.getLeftChild(),value) :
                containsValueRecursively(currentNode.getRightChild(),value);

//        if(value < currentNode.getData()){
//            return containsValueRecursively(currentNode.getLeftChild(), value);
//        } else {
//            return containsValueRecursively(currentNode.getRightChild(), value);
//        }
    }



}
