package com.revature.util;

public class MyBinarytree {

    private  TreeNode root;

    public void add(Integer value){
        this.root = addRecursively(this.root, value);

    }

    private  TreeNode addRecursively(TreeNode  currentNode, Integer value){

        // if the node passed to this method is null , return a new node containing the value

        if(currentNode == null){
            System.out.println(" current node is null , creating new node to add to tree ...");
            return new TreeNode(value);
        }
        /*
        if hte value being added is less than the value of the current node , then recursively
         invoke this method (addRecusively) to attempt to add a new value to the left child
         pf the current node
         */

        if(value < currentNode.getData()){
            System.out.println(" the new value is less than the current node's value");
            System.out.println("attempting to add a ner value to the left child node");

            TreeNode temp = addRecursively(currentNode.getLeftChild(),value);
            currentNode.setLeftChild(temp);
        }

        /*
        if hte value being added is less than the value of the current node , then recursively
         invoke this method (addRecusively) to attempt to add a new value to the right child
         of the current node
         */
        else if(value> currentNode.getData()){
            System.out.println(" the new value is greater than the current node's value");
            System.out.println("attempting to add a ner value to the right child node");

            TreeNode temp = addRecursively(currentNode.getRightChild(),value);
            currentNode.setRightChild(temp);

        }

        /*
        if the value being added is neither less or breater than the value of the current
        node, simply return the current node
         */

        return currentNode;

    }

    public boolean containsValue(Integer value){
        return containsValueRecursively(this.root,value);
    }


    public boolean containsValueRecursively(TreeNode currentNode, Integer value){


        /*
        if the current node is null , then the ... value is not stored within the
        tree, to return false
         */
        if ( currentNode == null){
            return false;
        }
        /*
        If the value contained within the current node is equal to the sought value,
            return true.
         */


        if (value.equals(currentNode.getData())){
            return true;
        }

        /*
        if the sought value is less than the calue of the current nod. then we know
        that we need to explore the nodes to the left of the current node

        likewise, if the sought value is greater than the value of the current nod. then we know
        that we need to explore the nodes to the right of the current node
         */

        //if(value < currentNode.getData()){
          //  return containsValueRecursively(currentNode.getLeftChild(),value);
        //} else {
          //  return  containsValueRecursively(currentNode.getRightChild(),value);
        //}

        return (value <currentNode.getData()) ?
                containsValueRecursively(currentNode.getLeftChild(),value)
                :
                containsValueRecursively(currentNode.getRightChild(),value);



    }
}
