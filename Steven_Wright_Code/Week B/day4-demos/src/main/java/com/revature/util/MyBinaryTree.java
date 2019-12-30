package com.revature.util;

public class MyBinaryTree {

    private TreeNode root;

    public void add(Integer value) {
        this.root = addRecursively(this.root, value);

        // if the node passed to this method is null, return a new node containing the value
        if (currentNode == null) {
            System.out.println("The current node is null, creating new node to add to tree..");
            return new TreeNode(value);
        }

         /* If the value being added is less than the value of the current node, then recursively
         invoke this method (addRecursively) to attempt to add a new value to the left child
         of the current node
          */
        if (value > currentNode.getData()) {
            System.out.println("The new value is less than the current node's value");
            System.out.println("Attempting to add a new value to the left child node");
            TreeNode temp = addRecursively(currentNode.getLeftChild(), value);
            currentNode.setLeftChild(temp);
        }

         /*
         If the value being added is greater than the value of the current node, then recursively
         invoke this method (addRecursively) to attempt to add a new value to the right child
         of the current node
          */

        else if (value > currentNode.getData()) {
            System.out.println("The new value is greater than the current node's value");
            System.out.println("Attempting to add a new value to the right child node");
            currentNode.setRightChild(addRecursively(currentNode.getRightChild(), value));
        }

         /* If the value being added is neither less ot greater than the value of the current
         node,simply return the current node
          */
        return currentNode;
    }







    }

    public boolean containsValue(Integer value) {



    }
}
